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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        int pre = Integer.MIN_VALUE;
        boolean first = true;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (!first && pre >= cur.val) return false;
                first = false;
                pre = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }
}