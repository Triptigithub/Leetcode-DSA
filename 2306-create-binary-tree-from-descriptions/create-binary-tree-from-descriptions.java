
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
import java.util.*;
   // public TreeNode createBinaryTree(int[][] arr) {
    //     HashSet<Integer> map = new HashSet<>();
    //     HashSet<TreeNode> hs = new HashSet<>();
    //     for (int i = 0; i < arr.length; i++) {
    //         int parent = arr[i][0];
    //         int child = arr[i][1];
    //         int dir = arr[i][2];

    //         //check if map contains the parent and child
    //         if (map.contains(parent)) {

    //             TreeNode pa = null;
    //             for (TreeNode node : hs) {
    //                 if (node.val == parent) {
    //                     // found it!
    //                     pa = node;
    //                     break;
    //                 }
    //             }

    //             if (map.contains(child)) {

    //                 TreeNode ch = null;
    //                 for (TreeNode node : hs) {
    //                     if (node.val == child) {

    //                         ch = node;
    //                         break;
    //                     }
    //                 }

    //                 if (dir == 1)
    //                     pa.left = ch;
    //                 else
    //                     pa.right = ch;

    //             } else {
    //                 //child ki node bnao
    //                 TreeNode chnode = new TreeNode(child);
    //                 map.add(child);
    //                 hs.add(chnode);
    //                 if (dir == 1)
    //                     pa.left = chnode;
    //                 else
    //                     pa.right = chnode;
    //             }

    //         } else {
    //             TreeNode panode = new TreeNode(parent);
    //             map.add(parent);
    //             hs.add(panode);
    //             if (map.contains(child)) {

    //                 TreeNode ch = null;
    //                 for (TreeNode node : hs) {
    //                     if (node.val == child) {

    //                        ch = node;
    //                         break;
    //                     }
    //                 }

    //                 if (dir == 1)
    //                     panode.left = ch;
    //                 else
    //                     panode.right = ch;
    //             } else {
    //                 //child ki node bnao
    //                 TreeNode chnode = new TreeNode(child);
    //                 map.add(child);
    //                 hs.add(chnode);
    //                 if (dir == 1)
    //                     panode.left = chnode;
    //                 else
    //                     panode.right = chnode;
    //             }

    //         }

    //     }

    //     //now map has  [all node ]
    //     TreeNode root = null;
    //     for (int i = 0; i < arr.length; i++) {
    //         int child = arr[i][1];

    //          for (TreeNode node : hs) {
    //                     if (node.val == child) {

    //                        root = node;
    //                         break;
    //                     }
    //          }
    //     }
    //     return root;

































class Solution {
  public TreeNode createBinaryTree(int[][] arr) {
    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> children = new HashSet<>();

    for (int[] relation : arr) {
      int parentVal = relation[0];
      int childVal = relation[1];
      int isLeft = relation[2];

      // Get or create parent node
      TreeNode parent = map.getOrDefault(parentVal, new TreeNode(parentVal));
      map.putIfAbsent(parentVal, parent);

      // Get or create child node
      TreeNode child = map.getOrDefault(childVal, new TreeNode(childVal));
      map.putIfAbsent(childVal, child);

      // Connect child to parent
      if (isLeft == 1) parent.left = child;
      else parent.right = child;

      // Mark child node
      children.add(childVal);
    }

    // Root is the node that was never a child
    for (int val : map.keySet()) {
      if (!children.contains(val)) {
        return map.get(val);
      }
    }

    return null;
  }
}
