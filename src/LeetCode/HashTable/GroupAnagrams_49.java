package LeetCode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
    class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0)
                return new ArrayList<>();

            Map<String, List> ans = new HashMap<>();

            for (String str : strs) {
                int[] count = new int[26];
                for (char c : str.toCharArray()) {
                    count[c - 'a']++;
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    sb.append('#');
                    sb.append(count[i]);
                }

                String key = sb.toString();
                if (!ans.containsKey(key)) {
                    List<String> list = new ArrayList<>();
                    ans.put(key, list);
                }
                ans.get(key).add(str);
            }

            return new ArrayList(ans.values());
        }
    }
}
