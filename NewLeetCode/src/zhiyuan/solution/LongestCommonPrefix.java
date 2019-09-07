package zhiyuan.solution;

/**
 * ClassName:LongestCommonPrefix
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-09-07 14:30
 * Author:ningzhy3@gmail.com
 */
public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = new String();
        for (int j = 0; j < strs[0].length(); j++) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;

    }
}




