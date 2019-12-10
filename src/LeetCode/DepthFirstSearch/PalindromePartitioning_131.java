package LeetCode.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            if (s == null)  return ans;
            int n = s.length();
            boolean[][] isPalindrome = helper(s, n);
            ans = dfs(s, 0, isPalindrome, new ArrayList<Integer>(), ans);
            return ans;
        }

        private boolean[][] helper(String s, int n) {
            boolean[][] isPalindrome = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                isPalindrome[i][i] = true;
                if (i != n - 1) {
                    isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
                }
            }

            for (int i = n - 3; i >= 0; i--) {
                for (int j = i + 2; j < n; j++) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
                }
            }

            return isPalindrome;
        }

        private List<List<String>> dfs(String s, int startIndex, boolean[][] isPalindrome,
                                       List<Integer> positions, List<List<String>> ans) {
            int n = s.length();
            if (startIndex == n) {
                ans.add(constructAns(positions, s));
                return ans;
            }

            for (int i = startIndex; i < n; i++) {
                if (isPalindrome[startIndex][i]) {
                    positions.add(i);
                    ans = dfs(s, i + 1, isPalindrome, positions, ans);
                    positions.remove(positions.size() - 1);
                }
            }

            return ans;
        }

        private List<String> constructAns(List<Integer> positions, String s) {
            List<String> part = new ArrayList<>();
            part.add(s.substring(0, positions.get(0) + 1));
            for (int i = 1; i < positions.size(); i++) {
                int start = positions.get(i - 1) + 1;
                int end = positions.get(i) + 1;
                part.add(s.substring(start, end));
            }
            return part;
        }
    }
}
