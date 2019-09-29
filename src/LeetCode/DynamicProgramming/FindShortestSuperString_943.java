package LeetCode.DynamicProgramming;

import java.util.Arrays;

public class FindShortestSuperString_943 {
    class Solution {
        public int n;
        public String shortestSuperstring(String[] A) {
            n = A.length;
            int[][] g = new int[n][n];
            for (int i = 0; i < n; i++)
                for(int j = 0; j < n; j++) {
                    g[i][j] = A[j].length();
                    for(int k = 1; k <= Math.min(A[i].length(), A[j].length()); k++)
                        if(A[i].substring(A[i].length()-k).equals(A[j].substring(0, k)))
                            g[i][j] = A[j].length() - k;
                }

            int[][] dp = new int[1<<n][n];  //dp[s][i]:= min distance to visit nodes (represented as a binary state s) once
            //and only once and the path ends with i;
            int x = (Integer.MAX_VALUE)/2;
            for(int[] row: dp)
                Arrays.fill(row, x);
            int[][] parent = new int [1<<n][n];
            for(int[] row: parent)
                Arrays.fill(row, -1);

            for(int i = 0; i < n; i++)
                dp[1 << i][i] = A[i].length();

            for(int s = 1; s < (1 << n); s++) {
                for (int j = 0; j < n; j++) {
                    if ((s & (1 << j)) == 0) continue;   //if this state does not visit node j
                    int ps = s & ~(1 << j);
                    for (int i = 0; i < n; i++) {
                        if (dp[ps][i] + g[i][j] < dp[s][j]) {
                            dp[s][j] = dp[ps][i] + g[i][j];
                            parent[s][j] = i;
                        }
                    }
                }
            }

            int s = (1 << n) - 1;
            int min = Integer.MAX_VALUE/2;
            int index = 0;
            for (int i = 0; i < n; i++) {
                if(dp[s][i] < min) {
                    min = dp[s][i];
                    index = i;
                }
            }

//            System.out.println(min);
            String ans = "";
            while(s != 0) {
                int i = parent[s][index];
                if( i < 0)  ans = A[index] + ans;
                else ans = A[index].substring(A[index].length() - g[i][index]) + ans;
                s &= ~(1 << index);
                index = i;
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        FindShortestSuperString_943 cl = new FindShortestSuperString_943();
        Solution sl = cl.new Solution();
        String[] A = {"catg","ctaagt","gcta","ttca","atgcatc"};
        String ans = sl.shortestSuperstring(A);
        System.out.println(ans);
    }
}
