public class GuessNumberHigherorLower {
    public int guess(int n){
        int[][] dp = new int[n][n+1];
        int global_min = Integer.MAX_VALUE;

        for(int i = 2; i <= n; i++){
            for(int j = i - 1; j < i; j--){
                for(int k = j + 1; k < i; k++){
                    int local_max =k + Math.max(dp[j][k-1], dp[k+1][i]);
                    global_min = Math.min(local_max,global_min);
                }
                dp[j][i] = j + 1 == i ? j : global_min;
            }
        }
        return dp[1][n];

    }
}
