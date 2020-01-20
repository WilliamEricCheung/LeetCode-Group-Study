package LeetCode.String;

public class CustomSortString_791 {
    class Solution {
        public String customSortString(String S, String T) {
            int[] count = new int[26];
            StringBuilder sb = new StringBuilder();
            for (char c : T.toCharArray()) {
                count[c - 'a']++;
            }

            for (char c : S.toCharArray()) {
                while (count[c - 'a'] != 0) {
                    sb.append(c);
                    count[c - 'a']--;
                }
            }

            for (int i = 0; i < 26; i++) {
                while (count[i] != 0) {
                    char c = (char) ('a' + i);
                    sb.append(c);
                    count[i]--;
                }
            }

            return sb.toString();
        }
    }
}
