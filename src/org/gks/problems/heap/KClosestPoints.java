
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPoints {

    static Double[] kClosest(Double[] distances, int k) {
        Double[] d = new Double[k];

        Queue<Double> pq = new PriorityQueue<>(k);

        for (int i = 0; i < distances.length; i++) {
            if (pq.size() < k || pq.peek() < distances[i]) {
                if (pq.size() == k)
                    pq.remove();
                pq.add(distances[i]);
            }
        }

        return pq.toArray(d);
    }

    public static void main(String[] args) {
        Integer[][] points = new Integer[][] { { -2, -4 }, { 0, -2 }, { -1, 0 }, { 3, -5 }, { -2, -3 }, { 3, 2 } };
        int n = points.length;
        // System.out.println(n);
        Map<Double, Integer[]> distancetoPoint = new HashMap<>();
        Double[] ds = new Double[n];

        for (int i = 0; i < n; i++) {
            double d = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            distancetoPoint.put(d, points[i]);
            ds[i] = d;
        }

        for (Double double1 : ds) {
            System.out.print(double1 + " ");
        }

        // 4.47213595499958 2.0 1.0 5.830951894845301 3.605551275463989
        // 3.605551275463989
        Double[] res = kClosest(ds, 1);
        for (Double double1 : res) {
            for (int i : distancetoPoint.get(double1)) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

}
