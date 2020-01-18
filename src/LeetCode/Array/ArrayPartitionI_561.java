package LeetCode.Array;

import java.util.Arrays;

public class ArrayPartitionI_561 {
    class SolutionSorting {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i += 2)
                sum += nums[i];
            return sum;
        }
    }

    class SolutionExtraSpace {
        public int arrayPairSum(int[] nums) {
            int[] exist = new int[20001];
            for (int i = 0; i < nums.length; i++)
                exist[nums[i] + 10000]++;

            int ans = 0;
            boolean odd = true;
            for (int i = 0; i < exist.length; i++) {
                while (exist[i] != 0) {
                    if (odd)
                        ans += (i - 10000);
                    odd = !odd;
                    exist[i] --;
                }
            }
            return ans;
        }
    }
}
