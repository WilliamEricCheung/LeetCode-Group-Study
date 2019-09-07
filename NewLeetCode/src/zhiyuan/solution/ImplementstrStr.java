package zhiyuan.solution;

/**
 * ClassName:ImplementstrStr
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-09-06 22:02
 * Author:ningzhy3@gmail.com
 */
public class ImplementstrStr {

        public int strStr(String haystack, String needle) {


            if( needle.isEmpty()) return 0;
            if (haystack.length() < needle.length() ) return -1;
            for(int i = 0; i <= haystack.length()-needle.length();i++){
                int j =0;
                for(j = 0;j<needle.length();j++){
                    if(haystack.charAt(i+j) !=needle.charAt(j)) break;
                }
                if (j == needle.length()) return i;
            }
            return -1;
        }
    }




