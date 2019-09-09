public class BurstBallons {
    public int bb(int[] nums){
        int[] coins = new int[nums.length+2];
        int n = 1;
        for(int c : nums){
            if(c != 0) coins[n++] = c;
        }
        coins[0] = coins[n] = 1;
        int[][] maxCoin = new int[n][n];

        for(int dis = 2; dis <= n; dis++){
            for(int left = 0;left + dis <= n; left++){
                int right = left + dis;
                for(int i = left + 1; i <= right - 1; i++){
                    maxCoin[left][right] = Math.max(maxCoin[left][right],
                            coins[i-1]*coins[i]*coins[i+1] + maxCoin[left][i-1] + maxCoin[i+1][right]);
                }

            }
        }
        return maxCoin[0][n];
    }

}
