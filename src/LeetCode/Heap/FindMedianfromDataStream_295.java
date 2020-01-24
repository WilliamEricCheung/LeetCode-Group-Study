package LeetCode.Heap;

import java.util.*;

public class FindMedianfromDataStream_295 {
    class MedianFinder {
        private Queue<Integer> lower, higher;
        int size;

        /** initialize your data structure here. */
        public MedianFinder() {
            lower = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            higher = new PriorityQueue();

            size = 0;
        }

        public void addNum(int num) {
            if (size == 0) {
                lower.add(num);
                size++;
            }
            else if (size == 1) {
                if (num < lower.peek()) {
                    higher.add(lower.poll());
                    lower.add(num);
                } else {
                    higher.add(num);
                }

                size++;
            }
            else {
                int bound = higher.peek();
                if (num > bound) {
                    higher.add(num);
                }
                else
                    lower.add(num);

                while (lower.size() - higher.size() < 0) {
                    int higherTop = higher.poll();
                    lower.add(higherTop);
                }
                while (lower.size() - higher.size() > 1) {
                    higher.add(lower.poll());
                }

                size++;
            }

        }

        public double findMedian() {
            if (size % 2 == 0) {
                return (lower.peek() + higher.peek()) * 0.5;
            }

            else
                return lower.peek();
        }
    }

    class MedianFinderSuccinct {
        private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        private PriorityQueue<Integer> large = new PriorityQueue<>();
        private boolean even = true;

        public double findMedian() {
            if (even)
                return (small.peek() + large.peek()) / 2.0;
            else
                return small.peek();
        }

        public void addNum(int num) {
            if (even) {
                large.offer(num);
                small.offer(large.poll());
            } else {
                small.offer(num);
                large.offer(small.poll());
            }
            even = !even;
        }
    };

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
