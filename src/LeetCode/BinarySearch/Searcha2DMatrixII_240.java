package LeetCode.BinarySearch;

public class Searcha2DMatrixII_240 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) return false;
            int row = matrix.length, col = matrix[0].length;
            int start, end, mid;
            if (row < col) {
                for (int i = 0; i < row; i ++)  {
                    start = 0;
                    end = col - 1;
                    while (start + 1 < end) {
                        mid = (end - start) / 2 + start;
                        if(matrix[i][mid] == target)    return true;
                        if (matrix[i][mid] > target)    end = mid;
                        else    start = mid;
                    }

                    if (matrix[i][start] == target) return true;
                    if (matrix[i][end] == target)   return true;
                }
            }
            else {
                for (int i = 0; i < col; i ++)  {
                    start = 0;
                    end = row - 1;
                    while (start + 1 < end) {
                        mid = (end - start) / 2 + start;
                        if (matrix[mid][i] == target)   return true;
                        if (matrix[mid][i] > target)    end = mid;
                        else start = mid;
                    }

                    if (matrix[start][i] == target || matrix[end][i] == target) return true;
                }
            }

            return false;
        }
    }
}
