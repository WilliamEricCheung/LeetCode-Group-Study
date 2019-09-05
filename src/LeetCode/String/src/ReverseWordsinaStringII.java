public class ReverseWordsinaStringII {
    void reverse(char[] s, int i, int j){
        while(i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
    public void rwsII( char[] s){
        reverse(s,0, s.length -1);
        for(int i = 0, j = 0; j < s.length; j++ ){
            if(s[j+1] ==' '|| j == s.length - 1){
                reverse(s, i, j);
                i = j + 2;
            }
        }
    }
}
