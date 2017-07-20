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
    public void recoverTree(TreeNode root) {
        TreeNode cur = root, pre = null, pred = null, node1 = null, node2 = null;
        while (cur != null) {
            if (cur.left == null) {
                pred = cur;
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    pred = cur;
                    cur = cur.right;
                }
            }
            if (pred != null && cur != null && pred.val >= cur.val) {
                if (node1 == null) {
                    node1 = pred;
                    node2 = cur;
                } else node2 = cur;
            }
        }
        if (node1 != null) {
            int tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        }
    }
}