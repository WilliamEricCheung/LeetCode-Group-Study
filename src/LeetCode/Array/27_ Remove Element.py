from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        lenn = len(nums)
        i = 0
        while (i < lenn):

            if (nums[i] == val):
                nums.pop(i)
                i -= 1
                lenn -= 1
            i += 1
        return len(nums)