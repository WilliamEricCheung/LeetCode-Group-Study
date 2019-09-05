public class ReverseString {
    public String rs( String s){
        int i = 0;
        int j = s.length() - 1;
        char c[] = s.toCharArray();
        while(i < j){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        return new String(c);
    }

}
