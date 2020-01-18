package LeetCode.Array;

public class SortArrayByParityII_922 {
    class SolutionPartition {
        public int[] sortArrayByParityII(int[] A) {
            int left = 0, right = A.length - 1;
            while (left < A.length && right > 0) {
                while (left < A.length) {
                    if (A[left] % 2 == 1)
                        break;
                    left += 2;
                }
                while (right > 0) {
                    if (A[right] % 2 == 0)
                        break;
                    right -= 2;
                }
                if (left < A.length && right > 0) {
                    swap(A, left, right);
                }
            }
            return A;
        }

        private void swap(int[] A, int i, int j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }

    class Solution {
        public int[] sortArrayByParityII(int[] A) {
            int j = 1;
            for (int i = 0; i < A.length; i += 2)
                if (A[i] % 2 == 1) {
                    while (A[j] % 2 == 1)
                        j += 2;

                    // Swap A[i] and A[j]
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }

            return A;
        }
    }
}
