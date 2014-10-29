/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode cur = root, pre = null, head;
        while (cur != null) {
            head = null;
            pre = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                    }
                    pre = cur.left;
                    if (head == null) head = pre;
                }
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                    }
                    pre = cur.right;
                    if (head == null) head = pre;
                }
                cur = cur.next;
            }
            cur = head;
        }
    }
}