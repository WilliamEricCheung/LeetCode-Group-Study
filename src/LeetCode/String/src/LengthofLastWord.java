public class LengthofLastWord {
    public int length(String s){
        String str = s.trim();
        int len = 0;
        for(int i = str.length()-1; i>= 0; i--){
            if(str.charAt(i) != ' ') len++;
            else break;
        }
        return len;
    }
}
