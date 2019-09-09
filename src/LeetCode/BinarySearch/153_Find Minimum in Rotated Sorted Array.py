class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left = 0
        n = len(nums)
        right = n - 1
        if (nums[right] > nums[left]):
            return nums[left]
        while (right > left):
            mid = (right + left) // 2

            if (nums[mid] >= nums[0] and nums[mid] > nums[mid + 1]):
                return nums[mid + 1]
            elif (nums[mid] < nums[0]):

                right = mid
            else:
                left = mid + 1
        if (nums[left] > nums[0]):
            return nums[0]
        return nums[left]