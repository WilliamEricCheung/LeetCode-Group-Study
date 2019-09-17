package zhiyuan.solution;

import java.util.HashMap;

/**
 * ClassName:WordPattern
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-09-17 10:26
 * Author:ningzhy3@gmail.com
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if (pattern == null || str == null) return false;
        if (arr.length != pattern.length()) return false;
        HashMap<Character, Integer> MapP = new HashMap<Character, Integer>();
        HashMap<String, Integer> MapS = new HashMap<String, Integer>();

        for (int i = 0; i < pattern.length(); i++) {
            int a = MapP.getOrDefault(pattern.charAt(i), -1);
            int b = MapS.getOrDefault(arr[i], -1);
            if(a != b) return false;
            MapP.put(pattern.charAt(i),i);
            MapS.put(arr[i],i);
    }
        return true;
}}
