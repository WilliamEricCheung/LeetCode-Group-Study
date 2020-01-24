package LeetCode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementinaSortedMatrix_378 {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            Queue<int[]> queue = new PriorityQueue(new Comparator<int[]>() {
                @Override
                public int compare(int[] s, int[] t) {
                    return matrix[s[0]][s[1]] - matrix[t[0]][t[1]];
                }
            });

            for (int i = 0; i < matrix.length; i++) {
                queue.add(new int[]{i, 0});
            }

            for (int i = 1; i < k; i++) {
                int[] s = queue.poll();
                s[1]++;
                if (s[1] < matrix.length)
                    queue.add(s);
            }

            int[] s = queue.peek();
            return matrix[s[0]][s[1]];
        }
    }
}
