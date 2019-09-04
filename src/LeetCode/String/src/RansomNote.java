import java.util.HashMap;

public class RansomNote {
    public boolean canconstruct(String ransomnote, String magazine){
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (Character c : magazine.toCharArray()){
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        for(Character c : ransomnote){
            if(cnt.containsKey(c) == false || cnt.get(c) == 0) return false;
            cnt.put(c, cnt.get(c) -1);
        }
        return true;
    }
}
