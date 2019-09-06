class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        if (nums[0] == target):
            return 0
        if (nums[right] == target):
            return right

        while (right > left + 1):
            mid = int((left + right) / 2)
            if (nums[mid] == target):
                return mid
            elif (nums[mid] < target):
                left = mid
            else:
                right = mid
        return -1