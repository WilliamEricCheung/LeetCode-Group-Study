package LeetCode.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointstoOrigin_973 {
    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            Queue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
                @Override
                public int compare(Integer i, Integer j) {
                    int dist1 = points[i][0] * points[i][0] + points[i][1] * points[i][1];
                    int dist2 = points[j][0] * points[j][0] + points[j][1] * points[j][1];
                    return dist2 - dist1;
                }
            });

            for (int i = 0; i < points.length; i++) {
                queue.add(i);
                if (i >= K)
                    queue.poll();
            }

            int[][] ans = new int[K][2];
            int index = 0;
            for (int i : queue) {
                ans[index][0] = points[i][0];
                ans[index][1] = points[i][1];
                index ++;
            }

            return ans;
        }
    }
}
