import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins,int amount){
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int j = 0; coins[j] <= i && j <coins.length; j++){
                dp[i] =Math.min(dp[i], dp[i-j] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
