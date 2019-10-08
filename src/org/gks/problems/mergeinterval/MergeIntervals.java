

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.mergeinterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * Given a list of intervals, merge all the overlapping intervals to produce a list that has only
 * mutually exclusive intervals.
 */
public class MergeIntervals {

  public static List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() < 2)
      return intervals;
    List<Interval> mergeInterval = new ArrayList<>();

    Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

    Iterator<Interval> itr = intervals.iterator();
    Interval interval = itr.next();
    int start = interval.start;
    int end = interval.end;

    while (itr.hasNext()) {
      interval = itr.next();
      if (interval.start <= end) {// // overlapping intervals, adjust the 'end'
        end = Math.max(interval.end, end);
      } else {
        mergeInterval.add(new Interval(start, end));
        start = interval.start;
        end = interval.end;
      }
    }

    // add the last interval
    mergeInterval.add(new Interval(start, end));
    return mergeInterval;
  }

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 5));
    input.add(new Interval(7, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new Interval(6, 7));
    input.add(new Interval(2, 4));
    input.add(new Interval(5, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 6));
    input.add(new Interval(3, 5));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}

