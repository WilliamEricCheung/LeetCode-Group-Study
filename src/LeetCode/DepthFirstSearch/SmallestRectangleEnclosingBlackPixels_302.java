package LeetCode.DepthFirstSearch;

public class SmallestRectangleEnclosingBlackPixels_302 {
    class Solution {
        int xMin, xMax, yMin, yMax;
        public int minArea(char[][] image, int x, int y) {
            if (image == null)  return 0;
            xMin = xMax = x;
            yMin = yMax = y;
            dfs(image, x, y);

            return (xMax - xMin + 1) * (yMax - yMin + 1);
        }

        private void dfs(char[][] image, int x, int y) {
            if (!inBound(image, x, y))  return;

            image[x][y] = '0';
            xMin = Math.min(x, xMin);
            xMax = Math.max(x, xMax);
            yMin = Math.min(y, yMin);
            yMax = Math.max(y, yMax);
            dfs(image, x - 1, y);
            dfs(image, x + 1, y);
            dfs(image, x, y - 1);
            dfs(image, x, y + 1);
        }

        private boolean inBound(char[][] image, int x, int y) {
            if (x < 0 || x > image.length - 1)  return false;
            if (y < 0 || y > image[0].length - 1)   return false;
            if (image[x][y] == '0') return false;

            return true;
        }
    }
}
