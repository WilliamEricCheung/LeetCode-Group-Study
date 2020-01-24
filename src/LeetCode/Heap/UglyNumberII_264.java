package LeetCode.Heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UglyNumberII_264 {
    //Long.valueOf()
    //Long.intValue()
    class Solution {
        public int nthUglyNumber(int n) {
            int[] factors = {2, 3, 5};
            Queue<Long> heap = new PriorityQueue();
            Set<Long> seen = new HashSet();
            heap.add(Long.valueOf(1));
            for (int i = 1; i < n; i++) {
                long top = heap.poll();
                for (int f : factors) {
                    long product = top * f;
                    if (!seen.contains(product)) {
                        seen.add(top * f);
                        heap.add(top * f);
                    }
                }
            }

            return heap.poll().intValue();
        }
    }
}
