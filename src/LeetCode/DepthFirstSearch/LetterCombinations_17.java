package LeetCode.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

//solutions: dfs, bfs
public class LetterCombinations_17 {

    //api: Character.getNumericValue();
    //construction of String: new String(char[]);
    //注意当输入为空时，返回空
    class Solution_dfs {
        public List<String> letterCombinations(String digits) {
            String[] d = new String[]{" ",
                    "",
                    "abc",
                    "def",
                    "ghi",
                    "jkl",
                    "mno",
                    "pqrs",
                    "tuv",
                    "wxyz"};
            char[] c = new char[digits.length()];
            List<String> ans = new ArrayList<>();
            dfs(digits, 0, d, c, ans);
            return ans;
        }

        void dfs(String digits, int l, String[] d, char[] c, List<String> ans){
            if(l == digits.length()) {
                if(l > 0) ans.add(new String(c));   // when iput == null
                return;
            }

            String S = d[Character.getNumericValue(digits.charAt(l))];

            for(int i = 0; i < S.length(); i++) {
                c[l] = S.charAt(i);
                dfs(digits, l+1, d, c, ans);
            }

        }
    }

}
