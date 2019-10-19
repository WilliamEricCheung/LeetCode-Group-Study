package LeetCode.DynamicProgramming;

public class ClimbingStairs_70 {
    class Solution {
        public int climbStairs(int n) {
            if (n <= 2) return n;

            int twoStep = 1;
            int oneStep = 2;
            int ans;
            for (int i = 3; i <= n; i ++) {
                ans = oneStep + twoStep;
                if(i == n)  return ans;
                twoStep = oneStep;
                oneStep  = ans;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        ClimbingStairs_70 cl = new ClimbingStairs_70();
        Solution sl = cl.new Solution();
        System.out.println(sl.climbStairs(4));
    }
}
