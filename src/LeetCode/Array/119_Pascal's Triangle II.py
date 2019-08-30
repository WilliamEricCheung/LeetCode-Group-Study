class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        if (rowIndex == 0):
            return [1]

        if (rowIndex == 1):
            return [1, 1]
        a = [1, 1]
        for i in range(2, rowIndex + 1):
            b = [1 for z in range(i + 1)]
            for j in range(1, i):
                b[j] = a[j - 1] + a[j]
            a = b
        return b