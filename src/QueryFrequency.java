import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// PACKAGE/IMPORTS --------------------------------------------------

class Student implements Comparator<Student> {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.cgpa == o2.cgpa) {
            return o1.fname.compareTo(o2.fname);
        } else if (o1.fname.equals(o2.fname)) {
            return o1.id - o2.id;
        } else {
            return (int) (o2.cgpa - o1.cgpa);
        }
    }
}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        if (o1.score == o2.score) {
            return o1.name.compareTo(o2.name);
        } else {
            return o2.score - o1.score;
        }
    }

}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Printer {
    public <T> void printArray(T[] arr) {
        for (T t : arr) {
            System.out.println(t);
        }

    }

    public static class QueryFrequency {

        // Complete the freqQuery function below.
        static List<Integer> freqQuery(List<List<Integer>> queries) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            List<Integer> retList = new ArrayList<>();

            for (int i = 0; i < queries.size(); i++) {
                int op = queries.get(i).get(0);
                int num = queries.get(i).get(1);
                if (op == 1) {
                    if (!hash.containsKey(num))
                        hash.put(num, 1);
                    else
                        hash.put(num, hash.get(num) + 1);
                } else if (op == 2) {
                    if (hash.containsKey(num)) {
                        if (hash.get(num) <= 1)
                            hash.remove(num);
                        else
                            hash.put(num, hash.get(num) - 1);
                    }
                } else if (op == 3) {
                    if (hash.containsValue(num)) {
                        retList.add(1);
                    } else
                        retList.add(0);
                }
            }
            return retList;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> queries = new ArrayList<>();

            IntStream.range(0, q).forEach(i -> {
                try {
                    queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            List<Integer> ans = freqQuery(queries);

            bufferedWriter.write(ans.stream().map(Object::toString).collect(Collectors.joining("\n")) + "\n");

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
