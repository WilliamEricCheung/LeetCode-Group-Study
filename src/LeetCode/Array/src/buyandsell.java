public class buyandsell {
    public int maxprofit(int[] prices){
        int buy = prices[0];
        int profit = 0;
        for(int i = 1; i< prices.length; i++){
            if(buy > prices[i]) buy = prices[i];
            else profit = Math.max(profit, (prices[i] - buy));
        }
    return profit;
    }
}
