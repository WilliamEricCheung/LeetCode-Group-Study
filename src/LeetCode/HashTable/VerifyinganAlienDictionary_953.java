package LeetCode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class VerifyinganAlienDictionary_953 {
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            Map<Character, Integer> dict = new HashMap<>();

            int num = 0;
            for (char c : order.toCharArray()) {
                dict.put(c, num++);
            }

            for (int i = 0; i < words.length - 1; i++) {
                char[] prev = words[i].toCharArray();
                char[] next = words[i + 1].toCharArray();

                for (int j = 0; j < prev.length; j++) {
                    if (j >= next.length)   return false;
                    if (dict.get(prev[j]) > dict.get(next[j]))
                        return false;
                    else if (dict.get(prev[j]) < dict.get(next[j]))
                        break;
                }
            }

            return true;
        }
    }
}
