public class UniquePathsII {
    public int unique(int[][] obstaclegrid){
        int m = obstaclegrid.length;
        int n = obstaclegrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            if(obstaclegrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            if(obstaclegrid[0][j] == 1) break;
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n;j++){
                if(obstaclegrid[i][j] == 1) continue;
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
