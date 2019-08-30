class Solution:
    def reverseWords(self, s: str) -> str:
        a = s.split(' ')
        res = ""
        n = len(a)

        for i in range(n):
            if (a[n - i - 1] == ''):
                continue

            res += a[n - i - 1] + ' '
        res = res[:len(res) - 1]
        return res