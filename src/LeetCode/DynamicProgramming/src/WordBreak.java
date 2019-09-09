import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wb(String s, List<String> wordDict ){
        HashSet<String> dict = new HashSet<String>();
        for(String sr : wordDict){
            dict.add(sr);
        }
        boolean[] breakable = new boolean[s.length()+1];
        breakable[0] = true;
        for(int i = 1; i <= s.length();i++){
            for(int j = 0; j < i; j++){
                String sub = s.substring(j,i);
                if(dict.contains(sub)){
                    if(breakable[j] == true){
                        breakable[i] = true;
                        break;
                    }
                }
            }
        }
        return breakable[s.length()];
    }

}
