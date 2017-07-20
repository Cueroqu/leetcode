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
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        TreeNode prel, prer, curl = left, curr = right;
        while (curl != null) {
            if (curr == null) return false;
            if (curl.left == null) {
                if (curr.right != null) return false;
                if (curl.val != curr.val) return false;
                curl = curl.right;
                curr = curr.left;
            } else {
                if (curr.right == null) return false;
                prel = curl.left;
                prer = curr.right;
                while (prel.right != null && prel.right != curl) {
                    if (prer.left == null) return false;
                    if (prer.left == curr) return false;
                    prel = prel.right;
                    prer = prer.left;
                }
                if (prel.right == null) {
                    if (prer.left != null) return false;
                    prel.right = curl;
                    prer.left = curr;
                    curl = curl.left;
                    curr = curr.right;
                } else {
                    if (prer.left != curr) return false;
                    if (curl.val != curr.val) return false;
                    prel.right = prer.left = null;
                    curl = curl.right;
                    curr = curr.left;
                }
            }
        }
        if (curr != null) return false;
        return true;
    }
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        else return isSymmetric(root.left, root.right);
    }
}