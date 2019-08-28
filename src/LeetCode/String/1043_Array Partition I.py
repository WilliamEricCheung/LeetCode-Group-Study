from typing import List


class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()
        sum=0
        if len(nums)==0 :
            return 0
        for i in range(0,len(nums),2):
            sum+=nums[i]
        return sum