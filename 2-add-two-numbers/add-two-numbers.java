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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //hle se he reversed h to make our work easy

        //so
        ListNode one = l1;
        ListNode two = l2;
        int carry = 0;
        ListNode dum = new ListNode(-1);
        ListNode temp = dum;

        while(one != null || two != null){
            int v1 = (one != null) ? one.val : 0;
            int v2 = (two != null) ? two.val : 0;

            int val = v1 + v2 + carry;

            if(val > 9){
                int firstpart = val / 10;   // carry
                int secondpart = val % 10;  // digit to keep

                carry = firstpart;
                ListNode newnode = new ListNode(secondpart);
                dum.next = newnode;
                dum = dum.next;
            } else {
                carry = 0;
                ListNode newnode = new ListNode(val);
                dum.next = newnode;
                dum = dum.next;
            }

            if(one != null) one = one.next;
            if(two != null) two = two.next;
        }

        // if carry remains at last
        if(carry != 0){
            ListNode newnode = new ListNode(carry);
            dum.next = newnode;
        }

        return temp.next;
    }
}
