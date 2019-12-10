package LeetCode.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class N_Queens_51 {
    class Solution {
        private List<List<String>> output;
        public List<List<String>> solveNQueens(int n) {
            output = new ArrayList<>();
            if (n == 0) return output;
            dfs(n, new int[n], 0);
            return output;
        }

        private void dfs(int n, int[] cols, int depth) {
            if (depth == n) {
                buildSolution(cols);
                return;
            }

            for (int i = 0; i < n; i++) {
                if (isValid(cols, depth, i)) {
                    cols[depth] = i;
                    dfs(n, cols, depth + 1);
                }
            }

            return;
        }

        private void buildSolution(int[] cols) {
            List<String> solution = new ArrayList<>();
            for (int i : cols) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < cols.length; j++) {
                    if (j == i)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                solution.add(sb.toString());
            }

            output.add(solution);
        }

        private boolean isValid(int[] cols, int row, int col) {
            for (int i = 0; i < row; i ++) {
                if (col == cols[i]) return false;
                if (Math.abs(row - i) == Math.abs(col - cols[i]))   return false;
            }

            return true;
        }
    }
}
