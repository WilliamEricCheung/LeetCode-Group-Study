public class ReverseWordsinaString {
    public String rws( String s){
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i] + ' ');
        }
        return sb.toString().trim();
    }
}
