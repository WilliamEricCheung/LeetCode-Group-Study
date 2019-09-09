package zhiyuan.solution;

import java.util.HashMap;

/**
 * ClassName:FirstUniqueCharacterinaString
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-09-08 11:29
 * Author:ningzhy3@gmail.com
 */
public class FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {

        HashMap<Character, Integer> count = new HashMap<Character, Integer>();


        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
                if (count.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
        return -1;
        }


    public static void main(String[] args) {

        String s = new String();
        s = "a";
        FirstUniqueCharacterinaString f = new FirstUniqueCharacterinaString();
        int res = f.firstUniqChar(s);
        System.out.println(res);

    }

}
