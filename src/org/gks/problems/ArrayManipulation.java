
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ArrayManipulation {


        // Complete the arrayManipulation function below.
        static long arrayManipulation(int n, int[][] queries) {

      long max = 0;

            long[] a = new long[n];
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
            //Arrays.sort(a);
            return max;//a[n-1];
        }



        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] queries = new int[m][3];

            for (int i = 0; i < m; i++) {
                String[] queriesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 3; j++) {
                    int queriesItem = Integer.parseInt(queriesRowItems[j]);
                    queries[i][j] = queriesItem;
                }
            }

            long result = arrayManipulation(n, queries);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }

}
