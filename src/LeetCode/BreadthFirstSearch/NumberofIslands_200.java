package LeetCode.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands_200 {
    class SolutionBFS {
        public int numIslands(char[][] grid) {
            int ans = 0;
            if (grid == null ||grid.length == 0)   return ans;
            int m = grid.length;
            int n = grid[0].length;
//            int[] deltaX = new int[] {0, 0, -1, 1};
//            int[] deltaY = new int[] {-1, 1, 0, 0};

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '0')  continue;
                    queue.offer(i * n + j);
                    while (!queue.isEmpty()) {
                        int node = queue.poll();
                        int x = node / n;
                        int y = node % n;
                        grid[x][y] = '0';   //visited
                        if (x - 1 >= 0 && grid[x - 1][y] == '1')    queue.offer((x - 1) * n + y);
                        if (x + 1 < m && grid[x + 1][y] == '1') queue.offer((x + 1) * n + y);
                        if (y - 1 >= 0 && grid[x][y - 1] == '1')    queue.offer(x * n + y - 1);
                        if (y + 1 < n && grid[x][y + 1] == '1') queue.offer(x * n + y + 1);
                    }
                    ans ++;
                }
            }

            return ans;
        }
    }

    class SolutionDFS {
        int[] deltaX = new int[] {0, 0, -1, 1};
        int[] deltaY = new int[] {-1, 1, 0, 0};
        public int numIslands(char[][] grid) {
            int ans = 0;
            if (grid == null || grid.length == 0)   return ans;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        ans++;
                        dfs(grid, i, j);
                    }
                }
            }

            return ans;
        }

        private void dfs(char[][] _grid, int i, int j) {
            if (i < 0 || i >= _grid.length || j < 0 || j >= _grid[0].length) return;
            if (_grid[i][j] == '0') return;

            _grid[i][j] = '0';
            for (int k = 0; k < 4; k++)
                dfs(_grid, i + deltaX[k], j + deltaY[k]);

            return;
        }
    }
}
