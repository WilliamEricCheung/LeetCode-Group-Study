public class removeDuplicatesII {
    public int rmII(int[] nums){
    int loc = 2;
    for(int i = 2; i < nums.length; i++){
        if(! (nums[loc-2]==nums[loc-1]& nums[loc-1]== nums[i])){
            nums[loc++] = nums[i];
        }
    }
   return loc; }
}
