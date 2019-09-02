from typing import List

from pip._vendor.msgpack.fallback import xrange


class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if not T:
            return []
        if len(T) == 1:
            return [0]
        n = []
        res = []
        n.append((T[-1], 0))
        res.insert(0, 0)
        for i in xrange(0, len(T) - 1)[::-1]:
            val, count = n[-1]

            if (T[i] >= val):
                count = 0
                while (n):
                    vals, counts = n[-1]
                    if (T[i] < vals):
                        n.append((T[i], count + 1))
                        res.insert(0, count + 1)
                        break
                    count += counts
                    n.pop()
                if not n:
                    n.append((T[i], 0))
                    res.insert(0, 0)
            else:
                n.append((T[i], 1))
                res.insert(0, 1)
        return res

