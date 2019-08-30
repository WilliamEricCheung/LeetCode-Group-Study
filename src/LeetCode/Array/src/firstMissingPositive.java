public class firstMissingPositive {
    public int findtarget( int[] nums){
        if(nums == null) return 1;
        int k = 1;
        //桶排序,通过调换数值归位符合要求的数字，不符合要求的数字不动
        for(int i = 0; i <= nums.length; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                //nums[i) = i+1, so (nums.length => nums[i] >=1)
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }

        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1)  return i+1;
        }
        return nums.length+1;
    }
}
