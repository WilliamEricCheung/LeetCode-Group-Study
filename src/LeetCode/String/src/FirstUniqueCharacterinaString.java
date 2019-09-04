import java.util.HashMap;

public class FirstUniqueCharacterinaString {
    public int uniquestring(String str){
        HashMap<Character, Integer> cnt = new HashMap<>();
        for(Character c: str.toCharArray()){
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i< str.length(); i++){
            if(cnt.get(str.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
