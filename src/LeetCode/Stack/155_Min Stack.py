import sys

from pip._vendor.msgpack.fallback import xrange


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.q = []

    def push(self, x: int) -> None:
        self.q.append(x)

    def pop(self) -> None:
        self.q.pop()

    def top(self) -> int:
        return self.q[len(self.q) - 1]

    def getMin(self) -> int:
        return min(self.q)