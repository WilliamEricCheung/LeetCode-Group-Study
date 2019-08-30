import java.util.HashSet;

public class containDuplicates {
    public boolean cotainD(int[] nums){
        HashSet<Integer> set = new HashSet<Integer>();
                for(int i : nums){
                  if(set.contains(i)) return true;
                  else set.add(i);
                }
                return false;
    }
}
