class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        m = len(matrix)
        if (m == 0):
            return matrix
        n = len(matrix[0])
        dis = [[10002 for i in range(n)] for j in range(m)]
        queue = []
        for i in range(m):
            for j in range(n):
                if (matrix[i][j] == 0):
                    dis[i][j] = 0
                    queue.append((i, j))
        move = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        while (queue):
            x, y = queue.pop(0)
            for xm, ym in move:
                if (0 <= x + xm < m and 0 <= y + ym < n):
                    if (dis[x + xm][y + ym] > dis[x][y] + 1):
                        dis[x + xm][y + ym] = dis[x][y] + 1
                        queue.append((x + xm, y + ym))
        return dis


