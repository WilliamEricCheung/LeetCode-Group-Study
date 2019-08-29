class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        maxs = 0
        temp = 0
        for i in range(len(nums)):
            if (nums[i] == 1):
                temp += 1

            else:
                if (temp > maxs):
                    maxs = temp
                temp = 0
        if (temp > maxs):
            maxs = temp
        return maxs