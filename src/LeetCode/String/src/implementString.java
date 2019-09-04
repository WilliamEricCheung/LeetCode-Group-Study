public class implementString {
    public int implement(String haystack, String needle){
        if(needle.length() == 0) return 0;
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            if(haystack.substring(i, i + needle.length()).equals(needle)) return i;
        }
        return -1;
    }
}

