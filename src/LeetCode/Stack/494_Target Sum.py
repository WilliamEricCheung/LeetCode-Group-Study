class Solution:

    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        self.reached = {}

        def dfs(nums, index, sum, lens, target):
            if (lens == index):
                if (sum == target):
                    return 1
                return 0
            if (index, sum) not in self.reached:
                a = dfs(nums, index + 1, sum + nums[index], lens, target)
                b = dfs(nums, index + 1, sum - nums[index], lens, target)
                self.reached[(index, sum)] = a + b

            return self.reached[(index, sum)]

        return dfs(nums, 0, 0, len(nums), S)
