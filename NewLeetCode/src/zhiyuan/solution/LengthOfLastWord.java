package zhiyuan.solution;

/**
 * ClassName:LengthOfLastWord
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-09-07 22:55
 * Author:ningzhy3@gmail.com
 */
public class LengthOfLastWord {


    public int lengthOfLastWord(String s) {
        int pre = -1;
        int length = 0;
        s = s.trim();
        if (s.length() == 1 && s.charAt(0) != ' ') return 1;


        for (int i = 0; i < s.length(); ++i) {
            //if (i > 0 && s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') continue;
            if (s.charAt(i) == ' ') {
                pre = i;
            }
            if (i == s.length() - 1 && s.charAt(i) != ' ') {
                length = i - pre;
            }
        }
        return length;
    }


    public static void main(String[] args) {

        LengthOfLastWord lolw = new LengthOfLastWord();
        String s = new String();
        s = "b a  aa    ";
        int res = lolw.lengthOfLastWord(s);
        System.out.println(res);

    }


// lastIndexOf（）

        public int lengthOfLastWord2(String s) {
            s = s.trim();
            int res = s.lastIndexOf(' ');
            return s.length() - res -1 ;
        }

}