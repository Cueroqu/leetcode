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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        TreeNode curp = p, curq = q, prep, preq;
        while (curp != null) {
            if (curq == null) return false;
            if (curp.left == null) {
                if (curq.left != null) return false;
                if (curp.val != curq.val) return false;
                curp = curp.right;
                curq = curq.right;
            } else {
                if (curq.left == null) return false;
                prep = curp.left;
                preq = curq.left;
                while (prep.right != null && prep.right != curp) {
                    if (preq.right == null) return false;
                    if (preq.right == curq) return false;
                    prep = prep.right;
                    preq = preq.right;
                }
                if (prep.right == null) {
                    if (preq.right != null) return false;
                    prep.right = curp;
                    preq.right = curq;
                    curp = curp.left;
                    curq = curq.left;
                } else {
                    if (preq.right != curq) return false;
                    prep.right = null;
                    preq.right = null;
                    if (curp.val != curq.val) return false;
                    curp = curp.right;
                    curq = curq.right;
                }
            }
        }
        if (curq != null) return false;
        return true;
    }
}