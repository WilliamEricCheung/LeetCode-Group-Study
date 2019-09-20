package zhiyuan.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:RomanToInteger
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-09-20 08:20
 * Author:ningzhy3@gmail.com
 */
public class RomanToInteger {
    public int romantointerger (String s){

        Map<Character, Integer> roman = new HashMap<Character, Integer>();
        int result = 0;
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        for (int i = 0; i < s.length(); i++){

            char temp = s.charAt(i);
            char temp1 = s.charAt(i+1);
            if (i == s.length() - 1 || temp >= temp1)  result += roman.get(temp) ;
            else result -= roman.get(temp);
        }
        return result;
    }



}
