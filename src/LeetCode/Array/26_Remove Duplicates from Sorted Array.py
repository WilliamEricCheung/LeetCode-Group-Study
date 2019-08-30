from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:

        index=0
        while(index<len(nums)):
            if(index+1==len(nums)):
                break
            if(nums[index]==nums[index+1]):
                nums.pop(index+1)
                continue
            else:
                index+=1
        return len(nums)
