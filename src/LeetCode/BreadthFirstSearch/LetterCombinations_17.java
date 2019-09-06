package LeetCode.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations_17 {
    class Solution {
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
            List<String> ans = new ArrayList<>();
            if(digits.length() == 0) return ans;
            ans.add("");
            for(char digit: digits.toCharArray()) {
                List<String> tmp = new ArrayList<>();
                for(String t: ans) {
                    String s = d[Character.getNumericValue(digit)];
                    for(char c: s.toCharArray()) {
                        tmp.add(t + c);
                    }
                }
                ans = tmp;
            }
            return ans;
        }
    }

}
