import java.util.PriorityQueue;
class Solution {
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	int n;
	class Node implements Comparable<Node>{
		int x;
		int y;
		int dist;
		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
    
    boolean isOutOfBound(int x, int y) {
		if(x<0 || x>=n || y<0 || y>=n) return true;
		return false;
	}
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        boolean[][] visited = new boolean[n][n];
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,1));
        visited[0][0] = true;
        
        while(!pq.isEmpty()) {
        	Node now = pq.remove();
        	
        	if(now.x==n-1 && now.y==n-1) {
        		return now.dist;
        	}
        	
        	for(int i=0; i<8; i++) {
        		int nx = now.x + dx[i];
    			int ny = now.y + dy[i];
    			if(!isOutOfBound(nx, ny) && grid[nx][ny]==0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
    				pq.add(new Node(nx, ny, now.dist+1));
    			}
        	}
        }
        
        return -1;
    }
}