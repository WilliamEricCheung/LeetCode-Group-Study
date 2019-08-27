public class apple {
    public int removeElement(int[] nums, int value){
        if (nums == null) return 0;
        int slow = 0;
        for (int i = 0; i<nums.length; i++){
            if(nums[i] != value){
                nums[slow++]= nums[i];
            }
        }
    return slow;}
}