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
      public void solver2(TreeNode node,ArrayList<Integer> ls){
        if(node == null){
            ls.add(null); //make sure to add this as it ensure that we are keeping track of null value also means we are kepping track of structuew alonf with values
            return;
        }
        ls.add(node.val);
        solver2(node.right,ls);
        solver2(node.left,ls);
    }
    public void solver1(TreeNode node,ArrayList<Integer> ls){
        if(node == null) {
            ls.add(null);
            return;
        }
        ls.add(node.val);
        solver1(node.left,ls);
        solver1(node.right,ls);
    }
    public boolean isSymmetric(TreeNode root) {
        //can we something like 
        //run recursion from root left -> fill ans in list
        //run recursion from root right ->modified preorder and fill asn in list
        //if both lista re equal return ans;
        if(root.left == null && root.right == null)return true;

          ArrayList<Integer> ls1 = new ArrayList<>();
          ArrayList<Integer> ls2 = new ArrayList<>();

          solver1(root.left ,ls1);
          solver2(root.right,ls2);

          return ls1.equals(ls2);
    }
}