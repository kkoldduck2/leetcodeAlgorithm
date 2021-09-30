class Solution {
    static boolean[] visited;
    static HashMap<Integer, List<Integer>> hm;
    public boolean dfs(int curnode){
        // basecase 1
        if(visited[curnode]){
            return false;
        }
        
        // basecase 2
        if(hm.get(curnode) == null){
            return true;
        }
        
        visited[curnode] = true;
        for(int pre : hm.get(curnode)){
            if(dfs(pre)==false) return false;
        }
        visited[curnode] = false;
        // 모두 방문 성공
        hm.put(curnode, null);
        return true;
        
    }
    public boolean canFinish(int nc, int[][] pr) {
        
        hm = new HashMap<>();
        
        // hashMap에 그래프 정보 담기 (일단 여기서 잘 못 담았었음)
        for(int i=0; i<nc; i++){
            hm.put(i, new ArrayList<>());
        }
        
        for(int i=0; i<pr.length; i++){
            hm.get(pr[i][0]).add(pr[i][1]);
        }
        
        // 
        visited = new boolean[nc];
        
        for(int i=0; i<nc; i++){
            if(dfs(i) == false) return false;
        }
        
        return true;
    }
}