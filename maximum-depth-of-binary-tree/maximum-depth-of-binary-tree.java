/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int dfs(TreeNode now, int depth){
        if(now.left == null && now.right == null){
            return depth;
        }
        
        int ld=0;
        int rd=0;
        
        if(now.left != null){
            ld = dfs(now.left, depth+1);
        }
        if(now.right != null){
            rd = dfs(now.right, depth+1);
        }
        
        return Math.max(ld, rd);
        
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, 1);
    }
}