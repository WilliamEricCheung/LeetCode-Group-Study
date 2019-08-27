public class removeDuplicates {
    public int removeDuplicates(int[] nums){
        int slow = 1;
        for(int i = 1; i< nums.length; i++){
            if(nums[i-1] != nums[i]){
                nums[slow++] = nums[i];
            }
        }
    return slow;}
}
