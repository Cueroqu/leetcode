/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void addSubtrees(Queue<TreeLinkNode> queue, TreeLinkNode node) {
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
    }
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size() - 1;
            TreeLinkNode pre = queue.remove();
            addSubtrees(queue, pre);
            while (size -- > 0) {
                TreeLinkNode tmp = queue.remove();
                pre.next = tmp;
                pre = tmp;
                addSubtrees(queue, tmp);
            }
        }
    }
}