package LeetCode.Stack;

import java.util.Stack;

public class MaximalRectangle_85 {
    class Solution {
        private int currMax(int[] dp) {
            int max = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);

            for (int k = 0; k < dp.length; k++) {
                while (stack.peek() != -1 && dp[k] < dp[stack.peek()]) {
                    int index = stack.pop();
                    int depth = dp[index];
                    int len = k - 1 - stack.peek();
                    max = Math.max(max, depth * len);
                }

                stack.push(k);
            }

            while (stack.peek() != -1) {
                int depth = dp[stack.pop()];
                int len = dp.length - 1 - stack.peek();
                max = Math.max(max, depth * len);
            }

            return max;
        }

        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0)
                return 0;

            int[] dp = new int[matrix[0].length];
            int max = 0;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    dp[j] = (matrix[i][j] == '1') ? dp[j] + 1 : 0;
                }
                max = Math.max(max, currMax(dp));
            }

            return max;
        }
    }

    class SolutionOfficial {

        // Get the maximum area in a histogram given its heights
        public int leetcode84(int[] heights) {
            Stack< Integer > stack = new Stack < > ();
            stack.push(-1);
            int maxarea = 0;
            for (int i = 0; i < heights.length; ++i) {
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                    maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
                stack.push(i);
            }
            while (stack.peek() != -1)
                maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
            return maxarea;
        }

        public int maximalRectangle(char[][] matrix) {

            if (matrix.length == 0) return 0;
            int maxarea = 0;
            int[] dp = new int[matrix[0].length];

            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {

                    // update the state of this row's histogram using the last row's histogram
                    // by keeping track of the number of consecutive ones

                    dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
                }
                // update maxarea with the maximum area from this row's histogram
                maxarea = Math.max(maxarea, leetcode84(dp));
            }

            return maxarea;
        }
    }
}
