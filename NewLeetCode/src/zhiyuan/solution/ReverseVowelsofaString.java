package zhiyuan.solution;

/**
 * ClassName:ReverseVowelsofaString
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-09-14 22:10
 * Author:ningzhy3@gmail.com
 */
public class ReverseVowelsofaString {
    public String reverseVowel (String s){
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int start = 0;
        int end = s.length() - 1;
        while (start < end){

            while(start < end && !vowels.contains(chars[start] + "")) start++;
            while(start < end && !vowels.contains(chars[end] + "")) end--;
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;

        }
        return new String(chars);

    }
}
