package zhiyuan.solution;
import java.util.Arrays;
import java.util.HashMap;
/**
 * ClassName:ValidAnagram
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-09-17 10:52
 * Author:ningzhy3@gmail.com
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s == null || t == null) return false;
        if (s.length() != t.length()) return false;
     char[] ss = s.toCharArray();
     char[] tt = t.toCharArray();
     int[] arr = new int[26];
     int[] arr1 = new int[26];
      for (int i = 0; i < ss.length; i++){

          arr[ss[i] - 'a']++;
          arr1[tt[i] - 'a']++;
      }
        return Arrays.equals(arr,arr1);
    }
}
