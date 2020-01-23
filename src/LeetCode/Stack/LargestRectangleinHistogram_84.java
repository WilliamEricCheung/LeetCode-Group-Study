package LeetCode.Stack;

import java.util.Stack;

public class LargestRectangleinHistogram_84 {
    class SolutionBruteForce {
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0)
                return 0;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < heights.length; i++) {
                max = Math.max(max, heights[i]);
                int minHeight = heights[i];
                for (int j = i - 1; j >= 0; j--) {
                    minHeight = Math.min(minHeight, heights[j]);
                    max = Math.max(max, minHeight * (i - j + 1));
                }
            }

            return max;
        }
    }

    class SolutionMine {
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0)
                return 0;

            Stack<Integer> stack = new Stack<>();
            int max = 0;
            for (int i = 0; i < heights.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }

                while ((!stack.isEmpty()) && heights[i] < heights[stack.peek()]) {
                    int index = stack.pop();
                    int currHeight = heights[index];
                    int len = stack.isEmpty() ? i : i - 1 - stack.peek();
                    max = Math.max(currHeight * len, max);
                }

                stack.push(i);
            }

            while (!stack.isEmpty()) {
                int index = stack.pop();
                int currHeight = heights[index];
                int len = stack.isEmpty() ? heights.length : heights.length - 1 - stack.peek();
                max = Math.max(currHeight * len, max);
            }

            return max;
        }
    }

    class Solution {
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0)
                return 0;

            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int max = 0;
            for (int i = 0; i < heights.length; i++) {
                while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                    int currHeight = heights[stack.pop()];
                    int l = i - 1 - stack.peek();
                    max = Math.max(currHeight * l, max);
                }

                stack.push(i);
            }

            while (stack.peek() != -1) {
                int currHeight = heights[stack.pop()];
                int l = heights.length - 1 - stack.peek();
                max = Math.max(max, currHeight * l);
            }

            return max;
        }
    }
}
