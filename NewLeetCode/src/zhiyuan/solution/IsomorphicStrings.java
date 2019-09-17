package zhiyuan.solution;

import java.util.HashMap;

/**
 * ClassName:IsomorphicStrings
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-09-17 09:31
 * Author:ningzhy3@gmail.com
 */
public class IsomorphicStrings {


        public boolean isIsomorphic(String s, String t) {
            if(s == null || t == null) return false;
            if (s.length() != t.length()) return false;

            HashMap<Character, Integer> MapS = new HashMap<Character, Integer>();
            HashMap<Character, Integer> MapT = new HashMap<Character, Integer>();

            for (int i = 0; i < s.length(); i++) {
                int a = MapS.getOrDefault(s.charAt(i), -1);
                int b = MapT.getOrDefault(t.charAt(i), -1);
                if(a != b) return false;
                MapS.put(s.charAt(i),i);
                MapT.put(t.charAt(i),i);

            }
            return true;
        }
    }

