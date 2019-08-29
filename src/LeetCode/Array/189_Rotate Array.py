from typing import List


class Solution(object):
    def rotate(self, nums, k):
        l = len(nums)
        if (k >= l):
            k = k % l
        cur = k
        hold = nums[0]
        count = 0
        isover = 0
        while (count != l):
            if (cur == isover):
                nums[cur] = hold
                isover = (isover + 1) % l
                cur = (isover + k) % l
                hold = nums[isover]
            else:

                hold, nums[cur] = nums[cur], hold
                cur += k
                cur %= l
            count += 1