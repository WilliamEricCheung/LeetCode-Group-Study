from typing import List


class MyCircularQueue:
    start = -1
    end = -1
    nums = []

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the queue to be k.
        """
        global nums, start, end
        nums = [0 for i in range(k)]
        start = -1
        end = -1

    def enQueue(self, value: int) -> bool:
        """
        Insert an element into the circular queue. Return true if the operation is successful.
        """
        global nums, start, end
        if (end + 1 == start):
            return False
        if (start == -1):
            start = 0

        if (end + 1 >= len(nums)):
            if (start != 0):
                end = 0
                nums[end] = value
                return True
            else:
                return False

        end += 1

        nums[end] = value
        return True

    def deQueue(self) -> bool:
        """
        Delete an element from the circular queue. Return true if the operation is successful.
        """
        global nums, start, end
        if (start == -1):
            return False
        if (start == end):
            start = -1
            end = -1
            return True
        if (start + 1 >= len(nums)):
            start = 0
            return True
        start += 1
        return True

    def Front(self) -> int:
        """
        Get the front item from the queue.
        """
        global nums, start, end
        if (start != -1):
            return nums[start]
        else:
            return -1

    def Rear(self) -> int:
        """
        Get the last item from the queue.
        """
        global nums, start, end
        if (end != -1):
            return nums[end]
        else:
            return -1

    def isEmpty(self) -> bool:
        """
        Checks whether the circular queue is empty or not.
        """
        global nums, start, end
        if (start == -1):
            return True
        else:
            return False

    def isFull(self) -> bool:
        """
        Checks whether the circular queue is full or not.
        """
        global nums, start, end
        if (end + 1 == start):
            return True
        if (end + 1 >= len(nums)):
            if (start == 0):
                return True
            else:
                return False
