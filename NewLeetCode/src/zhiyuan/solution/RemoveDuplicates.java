package zhiyuan.solution;

/**
 * ClassName:RemoveDuplicates
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-09-05 16:34
 * Author:ningzhy3@gmail.com
 */
public class RemoveDuplicates {

        public int removeDuplicates(int[] nums) {
            int length = 0;
            int i = 1;
            while(i<nums.length){

                if(nums[length] == nums[i]){
                    nums[length]=nums[i];
                    i++;}
                else{
                    length++;
                    nums[length] = nums[i];
                    i++;

                }
            }
            return length+1;
        }
    }

