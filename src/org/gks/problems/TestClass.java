
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems;

/* IMPORTANT: Multiple classes and nested static classes are supported */

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import for Scanner and other utility classes
//import for Scanner and other utility classes
import java.util.Arrays;

//Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {

    static int lindex(Integer[] arr, int l) {
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;

            if (arr[mid] >= l)
                j = mid - 1;
            else
                i = mid + 1;
        }
        return i;
    }

    static int Uindex(Integer[] arr, int r) {
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;

            if (arr[mid] <= r)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return j;
    }

    public static int countRange(Integer[] arr, int l, int r) {
        int count = 0;
        count = Uindex(arr, r) - lindex(arr, l) + 1;
        return count;
    }

    public static int checkcount(Integer[] arr, int l, int r) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            if (arr[i] >= l && arr[j] <= r) {
                return (j - i + 1);
            }
            if (arr[i] < l)
                i++;
            if (arr[j] > r)
                j--;
        }
        return 0;
    }

    public static void main(String args[]) throws Exception {
        /*
         * Sample code to perform I/O: Use either of these methods for input
         */

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int N = Integer.parseInt(name);
        Integer[] profits = new Integer[N];

        String line = br.readLine();
        String[] strs = line.trim().split("\\s+");

        for (int i = 0; i < N; i++) {
            profits[i] = Integer.parseInt(strs[i]);
        }

        int Q = Integer.parseInt(br.readLine());
        Arrays.sort(profits);

        for (int j = 0; j < Q; j++) {
            String ln = br.readLine();
            String[] str = ln.trim().split("\\s+");
            int l = Integer.parseInt(str[0]);
            int r = Integer.parseInt(str[1]);
            System.out.println(TestClass.countRange(profits, l, r));
        }
    }
}
