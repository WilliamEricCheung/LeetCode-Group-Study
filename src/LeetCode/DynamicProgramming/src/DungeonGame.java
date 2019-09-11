public class DungeonGame {
    public int DungeonGame(int[][] game){
        int m = game.length;
        int n = game[0].length;
        int[][] health = new int[m+1][n+1];
        for(int i = 0; i < m + 1;i++) health[i][n] = Integer.MAX_VALUE;
        for(int j = 0; j < n + 1;j++) health[m][j] = Integer.MAX_VALUE;
        health[m][n-1] = health[m-1][n] = 1;

        for(int rowindex = m - 1; rowindex >= 0; rowindex-- ){
            for(int colindex = n - 1; colindex >= 0; colindex--){
                health[rowindex][colindex] =
                        Math.max(2,Math.min(health[rowindex + 1][colindex], health[rowindex][colindex + 1])
                                - game[rowindex][colindex]);

            }
        }
        return health[0][0];
    }
}
