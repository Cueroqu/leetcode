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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Stack<TreeNode> record = new Stack<TreeNode>();
        Stack<Integer> level = new Stack<Integer>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        TreeNode tmpnode;
        int tmplevel;
        List<Integer> tmpret;
        if (root == null) return ret;
        record.push(root);
        level.push(1);
        while (!record.empty()) {
            tmpnode = record.pop();
            tmplevel = level.pop();
            if (tmpnode != null) {
                if (ret.size() < tmplevel) {
                    tmpret = new ArrayList<Integer>();
                    ret.add(tmpret);
                } else {
                    tmpret = ret.get(tmplevel-1);
                }
                tmpret.add(tmpnode.val);
                if (tmpnode.right != null) {
                    record.push(tmpnode.right);
                    level.push(tmplevel+1);
                }
                if (tmpnode.left != null) {
                    record.push(tmpnode.left);
                    level.push(tmplevel+1);
                }
            }
        }
        return ret;
    }
}