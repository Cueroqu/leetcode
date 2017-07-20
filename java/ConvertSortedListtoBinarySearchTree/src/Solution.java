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
    ListNode list;
    
    public TreeNode sortedListToBST(int head, int tail) {
        if (head > tail) return null;
        int mid = (head + tail) >> 1;
        TreeNode left = sortedListToBST(head, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = left;
        list = list.next;
        parent.right = sortedListToBST(mid + 1, tail);
        return parent;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int size = 1;
        for (list = head; list.next != null; list = list.next, ++size);
        list = head;
        return sortedListToBST(0, size-1);
    }
}