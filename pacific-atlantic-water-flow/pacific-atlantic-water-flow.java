class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int m;
    static int n;
    
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static boolean isOutOfIndex(int r, int c){
        if(r<0 || c<0 || r>=m || c>= n) return true;
        return false;
    }
    
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        
        boolean[][] visited = new boolean[m][n];
        boolean[][] po = new boolean[m][n];
        Queue<Node> poq = new LinkedList<>();
        
        for(int r=0; r<m; r++){
            Node node = new Node(r, 0);
            poq.offer(node);
            po[r][0] = true;
            visited[r][0] = true;
        }
        
        for(int c=0; c<n; c++){
            Node node = new Node(0, c);
            poq.offer(node);
            po[0][c] = true;
            visited[0][c] = true;
        }
        
        while(!poq.isEmpty()){
            Node cur = poq.remove();
            int cx = cur.r;
            int cy = cur.c;
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(isOutOfIndex(nx, ny)) continue;
                
                if((heights[nx][ny] >= heights[cx][cy]) && !visited[nx][ny]){
                    poq.offer(new Node(nx, ny));
                    po[nx][ny] = true; 
                    visited[nx][ny] = true;
                }
            }
        }
        
        boolean[][] ao = new boolean[m][n];
        Queue<Node> aoq = new LinkedList<>();
        visited = new boolean[m][n];
        
        for(int r=0; r<m; r++){
            Node node = new Node(r, n-1);
            aoq.offer(node);
            ao[r][n-1] = true;
            visited[r][n-1] = true;
        }
        
        for(int c=0; c<n; c++){
            Node node = new Node(m-1, c);
            aoq.offer(node);
            ao[m-1][c] = true;
            visited[m-1][c] = true;
        }
        
        while(!aoq.isEmpty()){
            Node cur = aoq.remove();
            int cx = cur.r;
            int cy = cur.c;
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(isOutOfIndex(nx, ny)) continue;
                
                if((heights[nx][ny] >= heights[cx][cy]) && !visited[nx][ny]){
                    aoq.offer(new Node(nx, ny));
                    ao[nx][ny] = true; 
                    visited[nx][ny] = true;
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(ao[i][j] && po[i][j]){
                    List<Integer> li = new ArrayList<>();
                    li.add(i);
                    li.add(j);
                    result.add(li);
                }
            }
        }
        
        return result;
        
    }
}