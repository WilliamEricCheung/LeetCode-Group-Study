package zhiyuan.solution;

import javax.lang.model.type.NullType;
import java.util.HashMap;

/**
 * ClassName:RansomNote
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-09-09 22:40
 * Author:ningzhy3@gmail.com
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ran = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mag= new HashMap<Character, Integer>();

        for (int i = 0; i < ransomNote.length(); i++) {
            ran.put(ransomNote.charAt(i), ran.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }


        for (int i = 0; i < magazine.length(); i++) {
            mag.put(magazine.charAt(i), mag.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (mag.containsKey(ransomNote.charAt(i))) {
                if (mag.get(ransomNote.charAt(i)) >= ran.get(ransomNote.charAt(i))) {
                    //System.out.println(mag.get(magazine.charAt(i)));
                    //System.out.println(ran.get(ransomNote.charAt(i)));
                    continue;
                } else {
                    return false;
                }
            }
            else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String r = new String();
        String m = new String();
        r = "aaaa";
        m = "baaaaa";
        RansomNote f = new RansomNote();
        boolean res = f.canConstruct(r,m);

        System.out.println();
        System.out.println(res);

    }
}
