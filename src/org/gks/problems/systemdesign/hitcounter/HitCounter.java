

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.hitcounter;
/*
 * What if the data comes in unordered and several hits carry the same timestamp.
 *
 * Since the queue approach wouldn’t work without ordered data, this time go with arrays to store
 * the hit count in each unit of time.
 *
 * If we are tracking hits in the past 5 mins in seconds granularity which is 300 seconds, create 2
 * arrays of size 300. int[] hits = new int[300];
 *
 * TimeStamp[] times = new TimeStamp[300]; // timestamp of the last counted hit Given an incoming,
 * mod its timestamp by 300 to see where it locates in the hits array.
 *
 * int idx = timestamp % 300; => hits[idx] keeps the hit count took place in this second
 *
 * But before we increase the hit count at idx by 1, the timestamp really belongs to the second that
 * hits[idx] is tracking. timestamp[i] stores the timestamp of the last counted hit. If timestamp[i]
 * > timestamp, this hit should be discarded since it did not happened in the past 5 minute. If
 * timestamp[i] == timestamp, then hits[i] increase by 1. If timestamp[i] currentTime – 300.
 */

import java.util.ArrayList;
import java.util.List;

public class HitCounter {

  List<Integer> hits = new ArrayList<>(300);
  List<Integer> timeStamps = new ArrayList<>(300);

  void hit(int timestamp) {
    int idx = timestamp % 300;
    if (timeStamps.get(idx) != timestamp) {
      timeStamps.add(idx, timestamp);
      hits.add(idx, 1);
    } else {
      hits.add(idx, hits.get(idx) + 1);
    }
  }

  int getHits(int timestamp) {
    int res = 0;
    for (int i = 0; i < 300; ++i) {
      if (timestamp - timeStamps.get(i) < 300) {
        res += hits.get(i);
      }
    }
    return res;
  }

}

