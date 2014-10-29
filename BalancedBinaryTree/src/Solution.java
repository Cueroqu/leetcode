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
    
    public int treeHeight(TreeNode root, int base) {
        if (root == null) return base;
        int leftHeight = treeHeight(root.left, base+1), rightHeight = treeHeight(root.right, base+1);
        if (leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight-rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight);
    }
    
    public boolean isBalanced(TreeNode root) {
        int min = Integer.MAX_VALUE, max = -1;
        if (root == null) return true;
        int leftHeight = treeHeight(root.left, 1), rightHeight = treeHeight(root.right, 1);
        return (leftHeight >= 0) && (rightHeight >= 0) && (Math.abs(treeHeight(root.left, 1) - treeHeight(root.right, 1)) < 2);
    }
}