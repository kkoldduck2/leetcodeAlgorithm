class Solution {
    class Edge{
        int to;
        int w;
        public Edge(int to, int w){
            this.to = to;
            this.w = w;
        }
    }
    
    class Node implements Comparable<Node>{
        int num;
        int dist;
        public Node(int num, int dist){
            this.num = num;
            this.dist = dist;
        }
        
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int inf = 20000;
        
        List<Edge>[] graph = new List[n+1]; // graph[i] : i를 시작 지점으로 하는 모든 에지 리스트
        int[] d = new int[n+1]; // d[i] : source -> i까지 최단 거리
        
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Edge>();
            d[i] = inf;
        }
        
        for(int i=0; i<times.length; i++){
            graph[times[i][0]].add(new Edge(times[i][1], times[i][2]));
        }
        
        // 이걸 왜 써? 그냥 큐는 왜 안되지
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0));
        d[k] = 0;
        
        while(!pq.isEmpty()){
            Node now = pq.remove(); 
            
            for( Edge e  : graph[now.num]){
                if(d[e.to] > d[now.num] + e.w){
                    d[e.to] = d[now.num] + e.w;
                    pq.add(new Node(e.to, d[e.to]));
                }
            }
        }
        
        int max = 0;
        for(int i=1; i<=n; i++){
            if(d[i] == inf) return -1;
            max = Math.max(max, d[i]);
        }
        
        return max;
        
    }
}