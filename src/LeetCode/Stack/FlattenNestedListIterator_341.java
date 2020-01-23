package LeetCode.Stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator_341 {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        private Stack<NestedInteger> stack;

        private void pushStack(List<NestedInteger> nestedList) {
            Stack<NestedInteger> tmp = new Stack<>();

            for (NestedInteger item: nestedList) {
                tmp.push(item);
            }

            while (!tmp.isEmpty())
                stack.push(tmp.pop());
        }

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            pushStack(nestedList);
        }

        @Override
        public Integer next() {
            if (!hasNext())
                return null;

            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                pushStack(stack.pop().getList());
            }

            return !stack.isEmpty();
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
