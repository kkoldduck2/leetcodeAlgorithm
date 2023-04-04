class Solution {
    static int bfs(int startBomb, int[][] bombs, List<Integer>[] effect) {
		int n = bombs.length;
		boolean[] visited = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(startBomb);
		visited[startBomb] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int now = q.remove();
			
			for(int next : effect[now]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
					cnt += 1;
				}
			}
		}
		
		return cnt;
		
	}
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
		List<Integer>[] effect = new List[n];
		
        for(int i=0; i<n; i++) {
        	effect[i] = new ArrayList<>();
        }
        
        // i가 터졌을때
		for(int i=0; i<n; i++) {
			// j에게 영향을 줄 수 있는지
			for (int j=0; j<n; j++) {
				if(i==j) continue;
				
				// i와 j 간의 거리가 i의 반지름보다 작을 경우 -> effect[i]에 j 추가
				double dist = Math.pow(bombs[i][0]-bombs[j][0], 2) + Math.pow(bombs[i][1]-bombs[j][1], 2);
				
				if(dist <= Math.pow(bombs[i][2], 2)) {
					effect[i].add(j);
				}
			}
		}
		
		int maxCnt = 0;
		for(int i=0; i<n; i++) {
			int cnt = bfs(i, bombs, effect);
			maxCnt = Math.max(maxCnt, cnt);
		}
		
		return maxCnt;
    }
}