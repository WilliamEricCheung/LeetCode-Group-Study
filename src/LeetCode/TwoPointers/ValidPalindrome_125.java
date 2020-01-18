package LeetCode.TwoPointers;

public class ValidPalindrome_125 {
    class Solution {
        private boolean isLegit(char c) {
            if (c >= 'a' && c <= 'z')
                return true;
            if (c >= 'A' && c <= 'Z')
                return true;
            if (c >= '0' && c <= '9')
                return true;
            return false;
        }

        public boolean isPalindrome(String s) {
            char[] array = s.toCharArray();
            int l = 0, r = array.length - 1;

            while (l < r) {
                while (!isLegit(array[l]) && l + 1 < array.length)
                    l++;
                while (!isLegit(array[r]) && r - 1 >= 0)
                    r--;
                if (l >= r)
                    return true;
                if (Character.toLowerCase(array[l]) != Character.toLowerCase(array[r]))
                    return false;
                l++;
                r--;
            }
            return true;
        }
    }
}
