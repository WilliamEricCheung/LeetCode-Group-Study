package LeetCode.HashTable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords_648 {
    class Solution {
        public String replaceWords(List<String> dict, String sentence) {
            Set<String> dictSet = new HashSet<>();

            for(String word : dict)
                dictSet.add(word);

            StringBuilder ans = new StringBuilder();

            for(String word : sentence.split("\\s+")) {
                String prefix = new String();
                for(int i = 0; i <= word.length(); i++) {
                    prefix = word.substring(0, i);
                    if(dictSet.contains(prefix)) break;
                }
                if(ans.length() > 0) ans.append(" ");
                ans.append(prefix);
            }

            return ans.toString();
        }
    }
}
