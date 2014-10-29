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
    
    public int search(int[] inorder, int target, int head, int tail) {
        for (int i = head; i <= tail; ++i) {
            if (inorder[i] == target) return i;
        }
        return -1;
    }
    
    public int buildTree(TreeNode root, int[] postorder, int postpos, int[] inorder, int head, int tail, int inpos) {
        if (head > tail) return postorder.length;
        int tmp1, msl = postpos, left = postpos;
        if (postpos > 0) {
            tmp1 = search(inorder, postorder[postpos-1], inpos+1, tail);
            if (tmp1 != -1) {
                TreeNode tnode = new TreeNode(postorder[postpos-1]);
                root.right = tnode;
                left = msl = Math.min(msl, buildTree(root.right, postorder, postpos-1, inorder, inpos+1, tail, tmp1));
            }
        }
        --left;
        if (left >= 0) {
            tmp1 = search(inorder, postorder[left], head, inpos-1);
            if (tmp1 != -1) {
                TreeNode tnode = new TreeNode(postorder[left]);
                root.left = tnode;
                msl = Math.min(msl, buildTree(root.left, postorder, left, inorder, head, inpos-1, tmp1));
            }
        }
        return msl;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int inpos = search(inorder, root.val, 0, inorder.length-1);
        buildTree(root, postorder, postorder.length-1, inorder, 0, inorder.length-1, inpos);
        return root;
    }
}