class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        index = 0
        ans = 99999999
        sum = 0
        for i in range(len(nums)):
            sum += nums[i]
            while (sum >= s):
                sum -= nums[index]
                ans = min(ans, i + 1 - index)
                index += 1

        if (ans == 99999999):
            return 0
        return ans


