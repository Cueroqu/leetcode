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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int i = postorder.length - 1, j = inorder.length - 1;
        TreeNode cur = new TreeNode(postorder[i--]), root;
        root = cur;
        stack.push(cur);
        boolean pop = false;
        while (i >= 0 || !stack.isEmpty()) {
            if (!pop && (stack.isEmpty() || stack.peek().val != inorder[j])) {
                TreeNode tmp = new TreeNode(postorder[i--]);
                cur.right = tmp;
                cur = tmp;
                stack.push(tmp);
            } else if (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                cur = stack.pop();
                pop = true;
                --j;
            } else {
                pop = false;
                TreeNode tmp = new TreeNode(postorder[i--]);
                cur.left = tmp;
                cur = tmp;
                stack.push(tmp);
            }
        }
        return root;
    }
}