public class removeElement {
    public int(int[] nums, int target){
        int slow = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != target){
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }
}
