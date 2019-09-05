class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image:
            return []
        m = len(image)
        n = len(image[0])
        reach = [[0 for i in range(n)] for j in range(m)]
        queue = []
        queue.append((sr, sc))
        reach[sr][sc] = 1
        val = image[sr][sc]
        move = [(-1, 0), (1, 0), (0, 1), (0, -1)]
        while (queue):
            x, y = queue.pop()
            image[x][y] = newColor
            for xm, ym in move:
                if 0 <= x + xm < m and 0 <= y + ym < n and reach[x + xm][y + ym] == 0 and image[x + xm][y + ym] == val:
                    queue.append((x + xm, y + ym))
                    reach[x + xm][y + ym] = 1

        return image