public class LongestCommonPrefix {
    public static String findprefix(String[] str){
        if(str == null || str.length == 0) return " ";
        String res = str[0];
        for(int i = 1; i < str.length; i++){
            while(str[i].indexOf(res) != 0){
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;

    }
}
