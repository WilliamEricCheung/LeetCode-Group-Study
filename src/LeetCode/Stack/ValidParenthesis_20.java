package LeetCode.Stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis_20 {
    class Solution {
        public boolean isValid(String s) {
            if (s == null)  return true;
            HashMap<Character, Character> map = new HashMap<>();
            map.put('(', ')');
     //       map.put(')', '(');
            map.put('[', ']');
       //     map.put(']', '[');
            map.put('{', '}');
         //   map.put('}', '{');

            Stack<Character> stack = new Stack<>();

            for (char ch : s.toCharArray()) {
                if (stack.isEmpty())    stack.push(ch);
                else if (ch == map.get(stack.peek()))    stack.pop();
                else    stack.push(ch);
            }

            return stack.isEmpty();
        }
    }
}
