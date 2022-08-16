class Solution {
    static boolean[][] visited;
	static int m;
	static int n;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean isOutOfBound(int r, int c) {
		if(r<0 || r>=m || c<0 || c>=n) return true;
		return false;
	}
	static void dfs(int r, int c, char[][] grid) {
		if(grid[r][c]=='0') return;
		
		// 1 이면 계속 탐색
		for(int i=0; i<4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			if(!isOutOfBound(nr, nc) && !visited[nr][nc] && grid[nr][nc]=='1') {
				visited[nr][nc]= true;
				dfs(nr, nc, grid);
			}
		}
	}
    public int numIslands(char[][] grid) {
        m = grid.length;
		n = grid[0].length;
		visited = new boolean[m][n];
		
		int cnt = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j]=='1' && !visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j, grid);
					cnt ++;
				}
			}
		}
		
		return cnt;
    }
}