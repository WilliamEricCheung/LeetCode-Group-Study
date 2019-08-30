from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        count=0
        l=len(nums)
        while(1):
            nums.remove(0)
            if(l-count==len(nums)):
                break
            else:
                count+=1

        for i in range(count):
            nums.append(0)
