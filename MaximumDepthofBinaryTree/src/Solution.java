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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> record = new LinkedList<TreeNode>();
        if (root == null) return 0;
        record.add(root);
        int size, ret = 0;
        while (!record.isEmpty()) {
            size = record.size();
            while (size-- > 0) {
                TreeNode tmp = record.remove();
                if (tmp.left != null) record.add(tmp.left);
                if (tmp.right != null) record.add(tmp.right);
            }
            ++ret;
        }
        return ret;
    }
}