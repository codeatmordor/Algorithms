import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// PACKAGE/IMPORTS --------------------------------------------------
class Pair implements Comparable<Pair> {
    public Pair(int i, int i2) {
        f = i;
        s = i2;
    }

    int f;
    int s;

    @Override
    public int compareTo(Pair o) {
        return this.f - o.f;
    }
}

public class DateFormater {

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

    private static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        long count = 0;
        for (int i = 0; i < arr.size(); i++) {
            long a = arr.get(i);
            long key = a / r;

            if (counter.containsKey(key) && a % r == 0) {
                count += counter.get(key);
            }

            if (potential.containsKey(key) && a % r == 0) {
                long c = potential.get(key);
                counter.put(a, counter.getOrDefault(a, 0L) + c);
            }

            potential.put(a, potential.getOrDefault(a, 0L) + 1); // Every number
                                                                 // can be the
                                                                 // start of a
                                                                 // triplet.
        }
        return count;
    }

    static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        // Keep track of how many anagrams we've seen
        int totalCount = 0;

        // Generate all substrings (N^2)
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String currentSubString = s.substring(i, j);

                // Sort all strings E.g. ab & ba both == ab now
                char[] chars = currentSubString.toCharArray();
                Arrays.sort(chars);
                currentSubString = String.valueOf(chars);

                // If sorted substring has been seen before
                if (map.containsKey(currentSubString)) {
                    // Check how many times we've seen it and add that amount to
                    // the count
                    int value = map.get(currentSubString);
                    totalCount = totalCount + value;

                    // Increment the times we've seen the string
                    map.put(currentSubString, value + 1);
                } else {
                    // Never seen it before = insert and set to 1 to indiciate
                    // we've now seen it
                    map.put(currentSubString, 1);
                }
            }
        }
        return totalCount;
    }

    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> mp = new HashMap<>();

        for (String string : magazine) {
            mp.merge(string, 1, Integer::sum);
        }

        for (int i = 0; i < note.length; i++) {
            if (!mp.containsKey(note[i])) {
                System.out.println("No");
                return;
            }

            int counter = mp.get(note[i]) - 1;
            if (counter == 0)
                mp.remove(note[i]);
            else
                mp.put(note[i], counter);
        }

        System.out.println("Yes");

    }

    static long arrayManipulation(int n, int[][] queries) {
        long max = 0;

        int[] a = new int[n];
        Arrays.fill(a, 0);

        int noOfOp = queries.length;
        int j = 0;
        for (int i = 0; i < noOfOp; i++) {
            int start = queries[i][j];
            int end = queries[i][j + 1];
            int val = queries[i][j + 2];

            for (int k = start - 1; k <= end - 1; k++) {
                a[k] = a[k] + val;
                if (a[k] > max)
                    max = a[k];
            }
        }

        Arrays.parallelSort(a);
        return a[n - 1];

    }

    static int hourglassSum(int[][] arr) {
        int sumArr[] = new int[16];
        int index = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int s = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                sumArr[index] = s;
                index++;
            }
        }

        Arrays.parallelSort(sumArr);

        return sumArr[15];

    }

    static void minimumBribes(int[] q) {

        int minb = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - q[i + 1] > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i])
                    minb++;
            }
        }
        System.out.println(minb);
    }
}
