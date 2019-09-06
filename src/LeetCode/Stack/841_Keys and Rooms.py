class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        if not rooms:
            return True
        num_room = len(rooms)
        reach = [0 for i in range(num_room)]

        stack = []
        stack.append(0)
        reach[0] = 1
        while (stack):
            keys = []
            index = stack.pop()
            keys = rooms[index]
            for i in range(len(keys)):
                if (reach[keys[i]] == 0):
                    stack.append(keys[i])
                    reach[keys[i]] = 1
        for i in range(num_room):
            if (reach[i] == 0):
                return False
        return True
