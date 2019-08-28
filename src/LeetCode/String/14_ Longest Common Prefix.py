class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        if len(strs) == 1:
            return strs[0]

        lens = len(strs[0])
        step = len(strs)
        for i in range(0, len(strs[0])):

            a = strs[0][0:0 + lens - i]
            for j in range(step):
                b = strs[j].find(a)
                if (j == step - 1 and b == 0):
                    return a
                elif (b != 0):
                    break

        return ""