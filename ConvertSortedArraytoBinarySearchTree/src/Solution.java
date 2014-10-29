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
    
    public TreeNode buildTree(int[] num, int head, int tail) {
        if (head > tail) return null;
        int mid = (head + tail) >> 1;
        TreeNode tmp = new TreeNode(num[mid]);
        tmp.left = buildTree(num, head, mid-1);
        tmp.right = buildTree(num, mid+1, tail);
        return tmp;
    }
    
    public TreeNode sortedArrayToBST(int[] num) {
        return buildTree(num, 0, num.length-1);
    }
}