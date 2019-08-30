package zhiyuan.solution;

import javax.naming.ServiceUnavailableException;
import java.util.Arrays;

/**
 * ClassName:MaximumSubarray_53
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-08-30 12:12
 * Author:ningzhy3@gmail.com
 */
public class MaximumSubarray_53 {

    public int maxSubArray(int[] nums) {

        int SumArray[] = new int[nums.length];

        SumArray[0] = nums[0];
        for (int i=1; i<nums.length; i++){
            SumArray[i] = Math.max((SumArray[i-1]+nums[i]), nums[i]);
        }

        Arrays.sort(SumArray);

    return SumArray[SumArray.length-1];
    }


    public static void main(String[] args) {

        int nums [] = new int[] {1,2,3,4,1};
        MaximumSubarray_53 result = new MaximumSubarray_53();
        int sum = result.maxSubArray(nums);
        System.out.println(sum);
    }
}
