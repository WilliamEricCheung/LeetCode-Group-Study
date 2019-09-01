import queue
from typing import List



class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

            if not grid:
                return 0
            m=len(grid)
            n=len(grid[0])
            count=0
            reach=[[0 for i in range(n)]for j in range(m)]
            for i in range(m):
                for j in range(n):
                    if(reach[i][j]==0 and grid[i][j]=='1' ):
                        self.bfs(i,j,reach,grid,m,n)
                        count+=1
            return count


    def bfs(self,i,j,reach:List[List[int]], grid:List[List[str]],m,n):
        q = queue.Queue()
        q.put([i, j])
        reach[i][j]=1
        while(not q.empty()):
            x,y=q.get()
            if(x-1>=0 and grid[x-1][y]=='1' and reach[x-1][y]==0):
                q.put([x-1,y])
                reach[x - 1][y] = 1
            if(y-1>=0 and grid[x][y-1]=='1' and reach[x][y-1]==0):
                q.put([x,y-1])
                reach[x][y - 1] = 1
            if(x+1<m and grid[x+1][y]=='1' and reach[x+1][y]==0):
                q.put([x+1,y])
                reach[x + 1][y] = 1
            if(y+1<n and grid[x][y+1]=='1' and reach[x][y+1]==0):
                reach[x][y + 1] =1
                q.put([x,y+1])