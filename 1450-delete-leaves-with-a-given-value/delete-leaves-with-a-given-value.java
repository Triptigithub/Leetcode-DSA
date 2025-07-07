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

 //took help of solution section
class Solution {
    public boolean isleaf(TreeNode node){
        return  (node.left == null && node.right == null);
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)return null;


        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);
        if(isleaf(root) && root.val == target)return null;
     

        return root;
    }
}