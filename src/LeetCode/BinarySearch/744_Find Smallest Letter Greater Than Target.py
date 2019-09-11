class Solution(object):
    def nextGreatestLetter(self, letters, target):
        """
        :type letters: List[str]
        :type target: str
        :rtype: str
        """
        n = len(letters)
        left = 0
        right = n - 1
        while (right > left + 1):
            mid = (left + right) // 2
            if (ord(letters[mid]) > ord(target)):
                right = mid
            elif (ord(letters[mid]) <= ord(target)):
                left = mid

        if (ord(target) - ord(letters[left]) >= 0):
            if (right == n - 1 and letters[right] <= target):
                return letters[0]
            return letters[right]
        return letters[left]