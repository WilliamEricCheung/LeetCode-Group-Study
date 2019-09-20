package zhiyuan.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName:GroupAnagrams
 * PackgeName:zhiyuan.solution
 * Description:
 * Given an array of strings, group anagrams together.
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * @Date:2019-09-19 22:08
 * Author:ningzhy3@gmail.com
 */
public class GroupAnagrams {
    public List<List<String>> groupanagrams (String[] strs){


        ArrayList<ArrayList<String>>  arr = new ArrayList<ArrayList<String>>();
        HashMap<String, ArrayList> ans = new HashMap<String, ArrayList>();

        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);

            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }


    }

