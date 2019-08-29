# 26. Remove Duplicates from Sorted Array




```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int length=nums.length;
        if(length==0)return 0;
        
        int quickPointer;
        int slowPointer=1;
        int currentValue=nums[0];
        
        for(quickPointer=1;quickPointer<length;++quickPointer){
            if(nums[quickPointer]!=currentValue)
            {
                currentValue=nums[quickPointer];
                nums[slowPointer]=nums[quickPointer];
                ++slowPointer;
            };
        };          
        return slowPointer;
    }
}
```