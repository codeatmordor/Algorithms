package org.gks.problems.concurrency;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ArticleReader implements Callable<String> {
  ArrayBlockingQueue<String> bQ;
  private ConcurrentHashMap<String, Long> wordCount = new ConcurrentHashMap<>();

  ArticleReader(ArrayBlockingQueue<String> q, ConcurrentHashMap<String, Long> wordCount) {
    this.bQ = q;
    this.wordCount = wordCount;
  }

  private String readArticle(String articleUrl) throws Exception {
    URL url = new URL(articleUrl);
    return org.apache.commons.io.IOUtils.toString(url, "utf-8");
  }

  @Override
  public String call() {
    System.out.println("Thread Id :" + Thread.currentThread().getId());
    try {
      // System.out.println("In Run.");
      String url;
      // consuming messages until exit message is received
      while (bQ.peek() != null) {
        url = bQ.poll();
        System.out.println(url);
        // Thread.sleep(10);
        String content = readArticle(url);
        // System.out.println(content);

        String[] allTokens = content.split(" ");
        for (int i = 0; i < allTokens.length; i++) {
          // System.out.println("Token :" + allTokens[i]);
          if (wordCount.containsKey(allTokens[i])) {
            wordCount.put(allTokens[i], wordCount.get(allTokens[i]) + 1);
          } else {
            wordCount.put(allTokens[i], (long) 1);
          }
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
}


public class DirectoryWordFrequencyCounter {

  private static ConcurrentHashMap<String, Long> wordCount = new ConcurrentHashMap<>();


  private static List<String> readURLs(String filePath) throws IOException {
    InputStream inputStream = new FileInputStream(new File(filePath));
    List<String> urls = org.apache.commons.io.IOUtils.readLines(inputStream);
    System.out.println(urls.get(0));
    inputStream.close();
    return urls;
  }


  public static void countMultiThreaded(String folderPath)
      throws IOException, InterruptedException {
    {
      File dir = new File(folderPath);
      File[] files = dir.listFiles();
      List<String> urls = new ArrayList<>();
      for (int i = 0; i < files.length; i++) {
        System.out.println(files[i].getAbsolutePath());
        if (files[i].isFile()) {
          urls.addAll(readURLs(files[i].getAbsolutePath()));
        }
      }

      List<ArrayBlockingQueue<String>> blockingQ = new ArrayList<>();
      int j = 0;
      for (int i = 0; i < urls.size() / 10 + 1; i++) {
        ArrayBlockingQueue<String> bq = getUrls(urls, j, urls.size() / 10 + 1);
        j = j + urls.size() / 10 + 1;
        blockingQ.add(bq);
      }

      List<ArticleReader> lisrar = new ArrayList<>();

      for (ArrayBlockingQueue<String> arrayBlockingQueue : blockingQ) {
        lisrar.add(new ArticleReader(arrayBlockingQueue, wordCount));
      }
      // ArticleReader ar1 = new ArticleReader(blockingQ, wordCount);

      ExecutorService pool = Executors.newFixedThreadPool(10);
      pool.invokeAll(lisrar);

      pool.shutdown();
      try {
        pool.awaitTermination(1, TimeUnit.MINUTES);
      } catch (InterruptedException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }

      System.out.println();
      System.out.println();
      System.out.println("=========================Final Result===================");
      for (Map.Entry<String, Long> e : wordCount.entrySet()) {
        // System.out.println(e.getKey() + ":" + e.getValue());
      }

      System.out.println("Size of Map - " + wordCount.size());
    }
  }

  private static ArrayBlockingQueue<String> getUrls(List<String> urls, int startIndex, int count) {
    ArrayBlockingQueue<String> bq = new ArrayBlockingQueue<>(urls.size() / 10 + 1);
    bq.addAll(urls.subList(startIndex, startIndex + count));
    return bq;

  }

  public static void main(String[] args) {
    String folderPath = "C:\\Test";
    try {
      countMultiThreaded(folderPath);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
