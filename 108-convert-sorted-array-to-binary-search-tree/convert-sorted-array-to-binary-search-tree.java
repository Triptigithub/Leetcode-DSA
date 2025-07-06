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
 //we used binary search to do this question
class Solution {
    public TreeNode make(int[] nums,int low,int high){
        if(low>high)return null;

        int mid = (low+high)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = make(nums,low,mid-1);
        node.right = make(nums,mid+1,high);

        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high = nums.length-1;

       return  make(nums,low,high);
         
    }
}