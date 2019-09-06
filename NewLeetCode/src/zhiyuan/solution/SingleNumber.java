package zhiyuan.solution;
import java.util.*;
/**
 * ClassName:SingleNumber
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-09-06 15:18
 * Author:ningzhy3@gmail.com
 */
public class SingleNumber {

        public int singleNumber(int[] nums) {
            Arrays.sort(nums);

            int res = 0;
            int i = 0;
            int j =  1;
            while (i < nums.length - 2){

                if(nums[i] != nums[j]){
                    res = nums[i];
                    return res;
                }
                i=i+2;
                j=j+2;
            }

            return nums[nums.length - 1];
        }
    }

