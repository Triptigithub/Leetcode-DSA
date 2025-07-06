/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public void solver(Node node, Node node2, Node root){
        //now traverse over tree find node and do node.next = node2
            if (root == null) return;

    // If we found the node, assign its next to node2
    if (root == node) {
        root.next = node2;
        return; // early exit after setting the pointer
    }

    // Traverse left and right subtrees
    solver(node, node2, root.left);
    solver(node, node2, root.right);

    }
    public void mark(Node root, ArrayList<Node> ls){
       for(int i=0; i<ls.size()-1;i++){
        Node node = ls.get(i);
        Node node2 = ls.get(i+1);
        solver(node,node2,root);
       }
    }
    public Node connect(Node root) {
        //maybe we can do something like doing level order and while filling dum in ans we will mark them

        
        if(root == null)return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            ArrayList<Node> ls = new ArrayList<>();
            int size = q.size();

            for(int i=0;i<size;i++){
                Node node  = q.poll();
                if(node.left!= null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
                ls.add(node);
            }
            mark(root,ls);
        }

        return root;
    }
}