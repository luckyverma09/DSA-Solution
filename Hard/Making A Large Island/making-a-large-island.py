from typing import List


class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        def dfs(i, j, island_id):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] != 1:
                return 0
            grid[i][j] = island_id  # Mark the cell with the current island_id
            area = 1
            for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                area += dfs(i + dx, j + dy, island_id)
            return area
        
        island_id = 2  # Start with 2 as the first island id
        island_areas = {0: 0}  # Dictionary to store island areas, with 0 as default area
        max_area = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    area = dfs(i, j, island_id)
                    island_areas[island_id] = area
                    max_area = max(max_area, area)
                    island_id += 1
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0:
                    neighbor_islands = set()
                    for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                        ni, nj = i + dx, j + dy
                        if 0 <= ni < len(grid) and 0 <= nj < len(grid[0]):
                            neighbor_islands.add(grid[ni][nj])
                    change_area = 1  # Include the current cell
                    for island in neighbor_islands:
                        change_area += island_areas[island]
                    max_area = max(max_area, change_area)
        
        return max_area



#{ 
 # Driver Code Starts

class IntMatrix:
    def __init__(self) -> None:
        pass
    def Input(self,n,m):
        matrix=[]
        #matrix input
        for _ in range(n):
            matrix.append([int(i) for i in input().strip().split()])
        return matrix
    def Print(self,arr):
        for i in arr:
            for j in i:
                print(j,end=" ")
            print()

if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        n = int(input())
        
        
        grid=IntMatrix().Input(n,n)
        
        obj = Solution()
        res = obj.largestIsland(grid)
        
        print(res)
# } Driver Code Ends