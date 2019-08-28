class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        a = {}
        for i in range(len(numbers)):
            if numbers[i] not in a:
                a[target - numbers[i]] = i
            else:
                return [a[numbers[i]] + 1, i + 1]

