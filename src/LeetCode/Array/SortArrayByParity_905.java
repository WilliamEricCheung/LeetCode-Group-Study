package LeetCode.Array;

public class SortArrayByParity_905 {
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            int left = 0, right = A.length - 1;
            while (left < right) {
                while (A[left] % 2 == 0 && left < right)
                    left++;
                while (A[right] % 2 == 1 && left < right)
                    right--;
                if (left < right)
                    swap(A, left, right);
            }
            return A;
        }

        private void swap(int[] A, int i, int j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}
