package LeetCode.TwoPointers;

import java.util.Arrays;

public class TwoSumLessThanK_1099 {
    class Solution {
        public int twoSumLessThanK(int[] A, int K) {
            if (A == null || A.length < 2)
                return -1;
            Arrays.sort(A);

            int S = Integer.MIN_VALUE;
            boolean flag = false;
            int left = 0, right = A.length - 1;
            while (left < right) {
                if (A[left] + A[right] < K) {
                    S = Math.max(S, A[left] + A[right]);
                    left++;
                    flag = true;
                }
                else
                    right--;
            }

            if (!flag)  return -1;
            return S;
        }
    }
}
