public class pascaltriangle {
    public int triangle(int n) {
        int[][] c = new int [n][n];
        for (int i = 0; i < n; i++ ){
            for(int j = 0; j< = i; j++){
                if(i == 0) c[i][j]= 1;
                else if(j == i) c[i][j]= 1;
                else(j< i) c[i][j]= c[i-1][j-1] + c[i-1][j];
            }
        }
    }
}
