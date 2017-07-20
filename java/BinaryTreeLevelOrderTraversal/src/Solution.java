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
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> tmp;
        TreeNode cur;
        if (root == null) {
            return ret;
        }
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            tmp = new ArrayList<Integer>();
            for (cur = queue.remove(); cur != null; cur = queue.remove()) {
                tmp.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            if (tmp.size() > 0) {
                queue.add(null);
                ret.add(tmp);
            }
        }
        return ret;
    }
}