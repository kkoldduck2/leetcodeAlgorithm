/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> hm = new HashMap<>();
    public Node cloneGraph(Node node){
        if (node == null) return null;
        if(hm.containsKey(node.val)){
            return hm.get(node.val);
        }
        
        Node myNode = new Node(node.val);
        
        hm.put(myNode.val, myNode);
        for(Node nb : node.neighbors){
            myNode.neighbors.add(cloneGraph(nb));
        }
        
        return myNode;
    }
}
