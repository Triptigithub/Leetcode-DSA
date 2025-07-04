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

 //by tripti
class Solution {
    int maxpath = Integer.MIN_VALUE;

    public int solver(TreeNode node){
        if(node == null)return 0;


        //doing math.max ensure we cut down the negative path and return zero
       int left = Math.max(0, solver(node.left));
       int right = Math.max(0, solver(node.right));



        maxpath = Math.max(maxpath,node.val + left +right);

        return node.val+Math.max(left,right);

    }
    public int maxPathSum(TreeNode root) {
       
        solver(root);
        return maxpath;
    }
}