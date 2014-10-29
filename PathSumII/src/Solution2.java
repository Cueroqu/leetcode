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
    
    public void dfs(TreeNode root, List<List<Integer>> ret, List<Integer> record, int cur, int sum) {
        record.add(root.val);
        cur += root.val;
        if (root.left != null) {
            dfs(root.left, ret, record, cur, sum);
        } else if (root.right == null && cur == sum) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(record);
            ret.add(tmp);
        }
        if (root.right != null) {
            dfs(root.right, ret, record, cur, sum);
        }
        record.remove(record.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> record = new ArrayList<Integer>();
        if (root == null) return ret;
        dfs(root, ret, record, 0, sum);
        return ret;
    }
}