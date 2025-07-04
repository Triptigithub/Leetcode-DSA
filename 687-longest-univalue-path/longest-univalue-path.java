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
    int cnt = Integer.MIN_VALUE;

    public int solver(TreeNode root){
         if(root == null)return 0;
        if(root.left == null && root.right == null )return 1;
       

        int left = solver(root.left);
        int  right =  solver(root.right);

              boolean leftMatch = root.left != null && root.val == root.left.val;
        boolean rightMatch = root.right != null && root.val == root.right.val;

        if (leftMatch && rightMatch) {
            cnt = Math.max(cnt, 1 + left + right);
            return 1 + Math.max(left, right);  // Only return max path from one side for parent use
        } else if (leftMatch) {
            cnt = Math.max(cnt, 1 + left);
            return 1 + left;
        } else if (rightMatch) {
            cnt = Math.max(cnt, 1 + right);
            return 1 + right;
        }

        cnt = Math.max(cnt, 1);
        return 1;
    }
        
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)return 0;
        if(root.left == null && root.right == null)return 0;
         solver(root);
        return Math.max(0, cnt - 1);
    }
}