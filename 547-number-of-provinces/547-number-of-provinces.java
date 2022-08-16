class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        
        int cnt = 0;
        for(int i=0; i<n; i++) {
        	if(!visited[i]) {
        		cnt ++;
        		Queue<Integer> q = new LinkedList<>();
        		q.add(i);
        		visited[i] = true;
        		while(!q.isEmpty()) {
        			int city = q.remove();
        			for(int j=0; j<n; j++) {
        				if(isConnected[city][j]==1 && !visited[j]) {
        					q.add(j);
        					visited[j] = true;
        				}
        			}
        		}
        	}
        }
        
        return cnt;
    }
}