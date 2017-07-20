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
    
    public int binarySearch(int[] inorder, int target, int head, int tail) {
        for (int i = head; i <= tail; ++i) {
            if (inorder[i] == target) return i;
        }
        return -1;
    }
    
    public int buildTree(TreeNode root, int[] preorder, int prepos, int[] inorder, int head, int tail) {
        if (head > tail) return -1;
        int pos = binarySearch(inorder, root.val, head, tail);
        int right = prepos, ret = prepos;
        if (prepos < preorder.length-1 && binarySearch(inorder, preorder[prepos+1], head, pos-1) != -1) {
            TreeNode tmp = new TreeNode(preorder[prepos+1]);
            root.left = tmp;
            right = buildTree(root.left, preorder, prepos+1, inorder, head, pos-1);
            ret = Math.max(ret, right);
        }
        ++right;
        if (right < preorder.length && binarySearch(inorder, preorder[right], pos+1, tail) != -1) {
            TreeNode tmp = new TreeNode(preorder[right]);
            root.right = tmp;
            ret = Math.max(ret, buildTree(root.right, preorder, right, inorder, pos+1, tail));
        }
        return ret;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        if (preorder.length == 0) return root;
        root = new TreeNode(preorder[0]);
        buildTree(root, preorder, 0, inorder, 0, inorder.length-1);
        return root;
    }
}