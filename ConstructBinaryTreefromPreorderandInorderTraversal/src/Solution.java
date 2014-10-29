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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Stack<TreeNode> nodestack = new Stack<TreeNode>();
        boolean pop = false;
        if (preorder.length == 0) return null;
        TreeNode cur = new TreeNode(preorder[0]), root;
        root = cur;
        nodestack.push(cur);
        for (int i = 1, j = 0; i < preorder.length || !nodestack.isEmpty(); ) {
            if (!pop && (nodestack.isEmpty() || nodestack.peek().val != inorder[j])) {
                TreeNode tmp = new TreeNode(preorder[i]);
                cur.left = tmp;
                cur = tmp;
                nodestack.push(tmp);
                ++i;
            } else if (!nodestack.isEmpty() && nodestack.peek().val == inorder[j]) {
                pop = true;
                cur = nodestack.pop();
                ++j;
            } else {
                pop = false;
                TreeNode tmp = new TreeNode(preorder[i]);
                cur.right = tmp;
                cur = tmp;
                nodestack.push(tmp);
                ++i;
            }
        }
        return root;
    }
}