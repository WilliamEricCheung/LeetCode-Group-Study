from pip._vendor.msgpack.fallback import xrange


class Solution:
    def numSquares(self, n: int) -> int:
        m = 0
        while (1):

            if ((m + 1) * (m + 1) < n):
                m += 1
            elif ((m + 1) * (m + 1) == n):
                return 1
            else:
                break;

        q = []
        for i in xrange(1, m + 1)[::-1]:
            q.append((i * i, 1))
        while (q):
            val, step = q.pop(0)

            for i in xrange(1, m + 1)[::-1]:
                temp = val + i * i
                if (temp == n):
                    return step + 1
                elif (temp < n):
                    q.append((temp, step + 1))