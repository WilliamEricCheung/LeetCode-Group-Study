public class ClimbStairs {
    public int climb(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        int current = 2;
        int previous = 1;
        for(int i = 3; i <= n; i++){
            current = current + previous;
            previous = current - previous;
        }
        return current;
    }
}
