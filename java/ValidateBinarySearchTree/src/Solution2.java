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
    
    TreeNode getNode(TreeNode l1, TreeNode l2, boolean less) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            if (less) return l1;
            else return l2;
        }
        if (less) return l2;
        return l1;
    }
    
    public boolean isValidBST(TreeNode root, TreeNode lb, TreeNode rb) {
        if (root == null) return true;
        TreeNode left = getNode(lb, root.left, true);
        TreeNode right = getNode(rb, root.right, false);
        if (left != null && left.val >= root.val) return false;
        if (right != null && right.val <= root.val) return false;
        return isValidBST(root.left, lb, root) && isValidBST(root.right, root, rb);
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
}