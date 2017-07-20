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
        TreeLinkNode pre = root, cur, child, next;
        while (pre != null && (pre.left != null || pre.right != null)) {
            cur = pre;
            while (cur != null) {
                if (cur.left != null && cur.right != null) {
                    cur.left.next = cur.right;
                    child = cur.right;
                } else {
                    child = (cur.left != null) ? cur.left : cur.right;
                }
                for (next = cur.next; next != null && next.left == null && next.right == null; next = next.next);
                if (next == null) break;
                child.next = (next.left != null) ? next.left : next.right;
                cur = next;
            }
            for (cur = (pre.left != null) ? pre.left : pre.right; cur != null && cur.left == null && cur.right == null; cur = cur.next);
            pre = cur;
        }
    }
}