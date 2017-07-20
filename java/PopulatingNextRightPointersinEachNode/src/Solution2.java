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
        if (root == null || root.left == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size() - 1;
            TreeLinkNode pre = queue.remove();
            if (pre.left != null) {
                queue.add(pre.left);
                queue.add(pre.right);
            }
            while (size-- > 0) {
                TreeLinkNode tmp = queue.remove();
                pre.next = tmp;
                pre = tmp;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }
            }
        }
    }
}