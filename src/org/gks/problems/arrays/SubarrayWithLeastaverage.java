package org.gks.problems.arrays;


public class SubarrayWithLeastaverage {


  private static void leastaveragesybarray(int[] input, int k) {
    int end = 0;
    int start = 0;
    double avg = Double.MAX_VALUE;
    int count = 0;
    int sum = 0;
    int i = 0;
    int j = 0;

    for (end = 0; end < input.length; end++) {
      sum += input[end];
      count++;
      if (count == k) {
        if (avg > sum / k) {
          avg = (double) sum / k;
          i = start;
          j = end;
        }
        count = count - 1;
        sum = sum - input[start];
        start++;
      }
    }

    System.out.println("Avg : " + avg);
    System.out.println("Start: " + i + " end: " + j);
  }

  public static void main(String[] args) {
    int[] input = new int[] {3, 7, 90, 20, 10, 50, 40};
    leastaveragesybarray(input, 4);
  }

}

