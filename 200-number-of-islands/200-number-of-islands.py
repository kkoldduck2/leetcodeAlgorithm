class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dx = [-1,1, 0, 0]
        dy = [0, 0, 1, -1]
        def dfs(i, j):
            if i<0 or i >= len(grid) or j<0 or j >= len(grid[0]) or grid[i][j]!='1':
                return
            grid[i][j]=0
            # 동서남북 탐색
            for dir in range(4):
                x = i + dx[dir]
                y = j + dy[dir]
                dfs(x,y)

        cnt = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] =='1':
                    dfs(i, j)
                    # 모든 육지 탐색 후 카운트 1증가
                    cnt += 1
        return cnt