package zhiyuan.solution;
import java.util.HashSet;
import java.util.Set;
/**
 * ClassName:ContainsDuplicate_217
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-08-29 16:52
 * Author:ningzhy3@gmail.com
 */
public class ContainsDuplicate_217 {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }



}
