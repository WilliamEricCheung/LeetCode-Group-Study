package LeetCode.DepthFirstSearch;

public class PalindromePartitioningII_132 {
    //O(n^3)
    class Solution_v1 {
        public int minCut(String s) {
            if (s == null)  return 0;
            int n = s.length();
            boolean[][] isPalindrome = palindromeJudge(s, n);
            int ans = computeMinCut(s, isPalindrome);
            return ans;
        }

        private boolean[][] palindromeJudge(String s, int n) {
            boolean[][] isPalindrome = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                isPalindrome[i][i] = true;
                if (i != n - 1)
                    isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            }

            //isPal[i][j] = (s[i] == s[j] && isPal[i + 1][j - 1]
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 2; j < n; j++) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
                }
            }

            return isPalindrome;
        }

        private int computeMinCut(String s, boolean[][] isPalindrome) {
            int n = s.length();
            int[][] cuts = new int[n][n];
            for (int i = 0 ; i < n; i++)
                cuts[i][i] = 0;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    if (isPalindrome[i][j]) {
                        cuts[i][j] = 0;
                        continue;
                    }
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, cuts[i][k] + cuts[k + 1][j] + 1);
                    }
                    cuts[i][j] = min;
                }
            }

            return cuts[0][n - 1];
        }
    }

    //O(n^2)
    class Solution {
        public int minCut(String s) {
            char str[] = s.toCharArray();
            boolean isPalindrome[][] = new boolean[s.length()][s.length()];
            int num[] = new int[s.length()];

            for(int i = 0; i < s.length(); i++) {
                int min = Integer.MAX_VALUE;
                for(int j = 0; j <= i; j++) {
                    if( str[i] == str[j] && (j + 1 >= i || isPalindrome[j + 1][i - 1]) ){
                        isPalindrome[j][i] = true;
                        min = j == 0 ? 0 : Math.min(min, num[j - 1] + 1);
                    }
                }
                num[i] = min;
            }
            return num[s.length() - 1];
        }
    }
}
