from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        count = 0
        z = 0
        l = len(nums)
        while (count < len(nums)):
            if (nums[count] == 0):
                nums.pop(count)
                z += 1

            else:
                count += 1
        for i in range(z):
            nums.append(0)