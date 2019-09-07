public class ReverseInteger {
    public int reverse( int x){
        int rev = 0;
        while (x != 0 ){
            int newrev = rev * 10 + x % 10;
            if((newrev - x % 10) / 10 != rev) return 0;
            rev = newrev;
            x = x / 10;
        }
        return rev;
    }
}
