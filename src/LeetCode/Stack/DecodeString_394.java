package LeetCode.Stack;

import java.util.Stack;

public class DecodeString_394 {
    //instaceof, String.valueOf()
    class Solution {
        public String decodeString(String s) {
            if (s == null)
                return new String();

            Stack<Object> stack = new Stack<>();
            int num = 0;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                }
                else if (c == '[') {
                    stack.push(num);
                    num = 0;
                }
                else if (c == ']') {
                    String storedString = popStack(stack);
                    Integer count = (Integer) stack.pop();
                    for (int i = 0; i < count; i++)
                        stack.push(storedString);
                }
                else
                    //turn Character to String
                    stack.push(String.valueOf(c));
            }

            return popStack(stack);
        }

        private String popStack(Stack<Object> stack) {
            Stack<String> buffer = new Stack<>();

            //determine if top of stack is String type: instanceof
            while (!stack.isEmpty() && (stack.peek() instanceof String)) {
                buffer.push((String) stack.pop());
            }

            StringBuilder sb = new StringBuilder();
            while (!buffer.isEmpty()) {
                sb.append(buffer.pop());
            }

            return sb.toString();
        }
    }
}
