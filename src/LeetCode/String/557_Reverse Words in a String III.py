class Solution:
    def reverseWords(self, s: str) -> str:
        a = s.split(' ')
        res = ""
        n = len(a)

        for i in range(n):
            if (a[i] == ''):
                continue
            temp = list(a[i])
            temp.reverse()

            res += "".join(temp) + ' '
        res = res[:len(res) - 1]

        return res