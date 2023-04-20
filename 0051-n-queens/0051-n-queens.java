class Solution {
    static int N;
	static List<List<String>> result;
    static boolean isOutOfBound(int r, int c) {
		if(r<0 || r>=N || c<0 || c>=N) return true;
		return false;
	}
    static boolean check(int r, int c, boolean[][] map) {
		for(int k=0; k<=r; k++) {
			if(map[k][c]) return false;
			
			if(!isOutOfBound(r-k, c-k) && map[r-k][c-k]) return false;
			
			if(!isOutOfBound(r-k, c+k) && map[r-k][c+k]) return false;
			
		}
		return true;
	}
	
	static void backtracking(boolean[][] map, int row) {
		if(row == N) {
			// 배치 끝. 정답 리스트에 담기
			List<String> li = new ArrayList<>();
			for(int r=0; r<N; r++) {
				String line = new String();
				for(int c=0; c<N; c++) {
					if(map[r][c]) {
						line += "Q";
					}else {
						line += ".";
					}
				}
				li.add(line);
			}
			result.add(li);
			return;
		}
		
		for(int col=0; col<N; col++) {
			if(check(row, col, map)) {
				map[row][col] = true;
				backtracking(map, row+1);
				map[row][col] = false;
			}
		}
		
	}
    
    public List<List<String>> solveNQueens(int n) {
        boolean[][] map = new boolean[n][n];
		N = n;
		result = new ArrayList<>();
		backtracking(map, 0);
		return result;
    }
}