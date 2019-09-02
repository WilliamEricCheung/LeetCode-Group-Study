
from typing import List

import queue

from pip._vendor.msgpack.fallback import xrange


class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        if "0000" in deadends:
            return -1
        deadends = set(deadends)
        q = [("0000", 0)]
        while (q):
            s, count = q.pop(0)
            for i, j in zip([*range(4)] * 2, [1] * 4 + [-1] * 4):
                temp = s[:i] + str((int(s[i]) + j) % 10) + s[i + 1:]

                if temp == target:
                    return count + 1
                if temp not in deadends:
                    deadends.add(temp)
                    q.append((temp, count + 1))

        return -1