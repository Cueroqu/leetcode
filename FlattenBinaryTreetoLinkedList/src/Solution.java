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
    
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode tmp, ptr;
        while (root != null) {
            tmp = root.left;
            if (tmp != null) {
                ptr = tmp;
                while (ptr.right != null) ptr = ptr.right;
                ptr.right = root.right;
                root.right = tmp;
                root.left = null;
            }
            root = root.right;
        }
    }
}