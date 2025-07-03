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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>>ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Stack<List<Integer>> st = new Stack<>(); ///////////// use stack 
        if(root == null)return ans;
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> dum = new ArrayList<>();
            int size =  q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                dum.add(node.val);

                if(node.left!= null)q.add(node.left);
                if(node.right != null)q.add(node.right);
                
            }

            //now add the dum in st
            st.add(dum);
        }



        //now loop over st add all stackelement in anslist
        while(!st.isEmpty()){
            
            ans.add(st.peek());
            st.pop();
        }
        return ans;
    }
}