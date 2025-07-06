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
    public void solver(TreeNode root, int val, TreeNode[] arr){
        if(root == null)return;

        if(root.val == val){
            arr[0] = root;
            return;
        }

        if(val<root.val)solver(root.left,val,arr);
        if(val>root.val)solver(root.right,val,arr);
    }
    public TreeNode searchBST(TreeNode root, int val) {
        //traverse over the tree agar apko val mill jaye then simply return that
        TreeNode[] arr =new TreeNode[1];
        solver(root,val,arr);
        if(arr[0] == null)return null;
        
        return arr[0];
    }
}