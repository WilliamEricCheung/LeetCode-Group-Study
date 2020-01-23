package LeetCode.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues_225 {
    class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            Queue<Integer> empty = (queue1.isEmpty()) ? queue1 : queue2;
            Queue<Integer> nonEmpty = (queue1.isEmpty()) ? queue2 : queue1;

            empty.add(x);
            while (!(nonEmpty.isEmpty()))
                empty.add(nonEmpty.poll());
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            Queue<Integer> nonEmpty = (queue1.isEmpty()) ? queue2 : queue1;
            return nonEmpty.poll();
        }

        /** Get the top element. */
        public int top() {
            Queue<Integer> nonEmpty = (queue1.isEmpty()) ? queue2 : queue1;
            return nonEmpty.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
