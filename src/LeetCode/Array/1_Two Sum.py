class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        minus=[]
        
        for i in range(len(nums)):
            if nums[i] not in minus:
                minus.append(target-nums[i])
            else:
                return(minus.index(nums[i]),i)