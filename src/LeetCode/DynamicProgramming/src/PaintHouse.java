public class PaintHouse {
    public int Paint(int[][] costs){
        int n = costs.length - 1;
        for(int i = 1; i < costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }
        return Math.min(Math.min(costs[n][0],costs[n][1]),costs[n][2]);
    }
}
