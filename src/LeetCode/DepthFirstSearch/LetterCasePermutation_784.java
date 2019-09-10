package LeetCode.DepthFirstSearch;

import java.lang.reflect.Array;
import java.util.*;
//import javafx.util.Pair;

public class LetterCasePermutation_784 {

    //number of entries in hashmap: hashmap.size;
    //converting char[] to string: String.valueOf(char[])
    class Solution {
        private List<String> ans = new ArrayList<>();
        private char[] curr;
        private List<Integer> indexes = new ArrayList<>();
        private List<Boolean> is_lowcase = new ArrayList<>();

        public List<String> letterCasePermutation(String S) {
//            ans.add(S);
            curr = S.toCharArray();
            for(int i = 0; i < S.length(); i++) {
                char c = curr[i];
                if (c >= 'a' && c <= 'z') {
                    indexes.add(i);
                    is_lowcase.add(true);
                }
                else if (c >= 'A' && c <= 'Z') {
                    indexes.add(i);
                    is_lowcase.add(false);
                }
            }
            DFS(0);
            return ans;
        }

        public void DFS(int d) {
            if(d == indexes.size()) {
                String curString = String.valueOf(curr);
                ans.add(curString);
                return;
            }

            int index = indexes.get(d);
            if(is_lowcase.get(d)) {
                curr[index] = (char) ((int) curr[index] - 'a' + 'A');
                DFS(d + 1);
                curr[index] = (char) ((int) curr[index] - 'A' + 'a');
            }
            else {
                curr[index] = (char) ((int) curr[index] - 'A' + 'a');
                DFS(d + 1);
                curr[index] = (char) ((int) curr[index] - 'a' + 'A');
            }

            DFS(d + 1);
        }
    }

    public static void main(String[] args) {
        String S = new String("a1b2");
        LetterCasePermutation_784 cl = new LetterCasePermutation_784();
        Solution obj = cl.new Solution();
        List<String> ans = obj.letterCasePermutation(S);
        System.out.println(ans);
    }
}
