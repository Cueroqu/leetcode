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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Queue<TreeNode> tq = new LinkedList<TreeNode>();
        Queue<Integer> ti = new LinkedList<Integer>();
        tq.add(root);
        ti.add(root.val);
        int size;
        while (!tq.isEmpty()) {
            size = tq.size();
            while (size-- > 0) {
                TreeNode tmp = tq.remove();
                int tmpi = ti.remove();
                if (tmp.left != null) {
                    tq.add(tmp.left);
                    ti.add(tmpi + tmp.left.val);
                } else if (tmpi == sum && tmp.right == null) return true;
                if (tmp.right != null) {
                    tq.add(tmp.right);
                    ti.add(tmpi + tmp.right.val);
                }
            }
        }
        return false;
    }
}