class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = 0
        r = len(nums) - 1
        if (l == r):
            return l
        while (l < r):
            mid = (l + r) // 2
            if (nums[mid] < nums[mid + 1]):
                l = mid + 1
            else:
                r = mid
        return l
