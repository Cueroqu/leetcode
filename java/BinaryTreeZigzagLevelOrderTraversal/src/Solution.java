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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> record = new Stack<TreeNode>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;
        record.push(root);
        boolean left = true;
        int size;
        while (!record.empty()) {
            Stack<TreeNode> tmp = new Stack<TreeNode>();
            List<Integer> list = new ArrayList<Integer>();
            while (!record.empty()) {
                TreeNode tmpnode = record.pop();
                list.add(tmpnode.val);
                if (left) {
                    if (tmpnode.left != null) tmp.push(tmpnode.left);
                    if (tmpnode.right != null) tmp.push(tmpnode.right);
                } else {
                    if (tmpnode.right != null) tmp.push(tmpnode.right);
                    if (tmpnode.left != null) tmp.push(tmpnode.left);
                }
            }
            left = !left;
            record = tmp;
            ret.add(list);
        }
        return ret;
    }
}