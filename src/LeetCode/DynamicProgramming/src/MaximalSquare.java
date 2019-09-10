public class MaximalSquare {
    public int max(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] findSquare = new int[m+1][n+1];
        int result = 0;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(findSquare[i][j] == 1){
                    findSquare[i][j] = 1+ Math.min(findSquare[i-1][j],
                            Math.min(findSquare[i-1][j-1],findSquare[i][j-1]));
                    result = Math.max(findSquare[i][j], result);

                }
            }
        }
        return result*result;
    }
}
