/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode make(ArrayList<Integer> ls,int low,int high){
        if(low>high)return null;

        int mid = (low+high)/2;
        TreeNode node = new TreeNode(ls.get(mid));
        node.left = make(ls,low,mid-1);
        node.right = make(ls,mid+1,high);

        return node;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> ls = new ArrayList<>();
        while(head!=null){
            ls.add(head.val);
            head = head.next;
        }
        int low = 0;
        int high = ls.size()-1;

       return make(ls,low,high);
         

    }
}