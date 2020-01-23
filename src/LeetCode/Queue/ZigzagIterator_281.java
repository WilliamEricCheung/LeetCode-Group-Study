package LeetCode.Queue;

import java.util.*;

public class ZigzagIterator_281 {
    public class ZigzagIterator {
        Queue<Iterator> queue;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            queue = new LinkedList<>();
            if (!v1.isEmpty())  queue.add(v1.iterator());
            if (!v2.isEmpty())  queue.add(v2.iterator());
        }

        public int next() {
            Iterator iter = queue.poll();
            int result = (Integer) iter.next();
            if (iter.hasNext()) queue.add(iter);
            return result;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
