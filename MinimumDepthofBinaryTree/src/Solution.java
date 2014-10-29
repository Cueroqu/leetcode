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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int size, level = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            level++;
            while (size-- > 0) {
                TreeNode tmp = queue.remove();
                if (tmp.left != null) queue.add(tmp.left);
                else if (tmp.right == null) return level;
                if (tmp.right != null) queue.add(tmp.right);
            }
        }
        return level;
    }
}