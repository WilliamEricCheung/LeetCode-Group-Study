package LeetCode.Stack;

import java.util.Stack;

public class MinStack_155 {
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min;

        /** initialize your data structure here. */
        public MinStack() {
            this.stack = new Stack<>();
            this.min = new Stack<>();
            min.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            this.stack.push(x);
            this.min.push((x < min.peek()) ? x : min.peek());
        }

        public void pop() {
            this.stack.pop();
            this.min.pop();
        }

        public int top() {
            return this.stack.peek();
        }

        public int getMin() {
            return this.min.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
