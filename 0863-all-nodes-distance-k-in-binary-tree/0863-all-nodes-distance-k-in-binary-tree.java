/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // Tree -> graph로 바꾸기
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer>[] graph = new List[501];
		for(int i=0; i<501; i++) {
			graph[i] = new ArrayList<>();
		}

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode now = q.remove();
            if(now.left != null){
                graph[now.val].add(now.left.val);
                graph[now.left.val].add(now.val);
                q.add(now.left);
            }
            if(now.right != null){
                graph[now.val].add(now.right.val);
                graph[now.right.val].add(now.val);
                q.add(now.right);
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[501];

        // target에서 k만큼 떨어진 노드 찾기
        Queue<int[]> q2 = new LinkedList<>();
        q2.add(new int[]{target.val,0});
        visited[target.val] = true;
        
        while(!q2.isEmpty()){
            int[] now = q2.remove();
            // System.out.println(now[0]+", "+now[1]);
            if(now[1] == k){
                answer.add(now[0]);
            } else if(now[1] < k){
                for(int next : graph[now[0]]){
                    if(!visited[next]){
                        q2.add(new int[]{next, now[1]+1});
                        visited[next] = true;
                    }
                }
            }
        }

        return answer;

    }
}