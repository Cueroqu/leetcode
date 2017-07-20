/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode fhead = new ListNode(0);
        fhead.next = head;
        if (head == null) return null;
        while ((fast != null) && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            fhead = fhead.next;
        }
        TreeNode root = new TreeNode(slow.val);
        fhead.next = null;
        if (slow != head) root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}