package zhiyuan.solution;

/**
 * ClassName:ThreeSumClosest
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-09-03 11:47
 * Author:ningzhy3@gmail.com
 */

import java.util.*;
import java.util.*;
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {


        int closest = nums[0] + nums[1] + nums[nums.length-1];
        int gap = Math.abs(closest - target);
        Arrays.sort(nums);//sort the array
        for (int i = 0;i < nums.length - 2;i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if (i>0 && nums[i] == nums[i-1]) {continue;}
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {return sum;}

                int newgap = Math.abs(sum - target);
                if (gap > newgap) {
                    gap = newgap;
                    closest = sum;
                }
                if (sum < target) {
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return closest;

    }
}




