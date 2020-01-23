package LeetCode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString_387 {
    class Solution {
        public int firstUniqChar(String s) {
            if (s == null || s.length() == 0)
                return -1;

            Map<Character, Integer> count = new HashMap();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                count.put(c, count.getOrDefault(c, 0) + 1);
            }

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (count.get(c) == 1)
                    return i;
            }
            return -1;
        }
    }
}
