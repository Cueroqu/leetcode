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
    
    public void dfs(List<List<Integer>> ret, List<Integer> cur, TreeNode root, int sum) {
        cur.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (0 == sum) 
                ret.add(new ArrayList<Integer>(cur));
        } else {
            if (root.left != null) dfs(ret, cur, root.left, sum);
            if (root.right != null) dfs(ret, cur, root.right, sum);
        }
        cur.remove(cur.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        if (root == null) return ret;
        dfs(ret, cur, root, sum);
        return ret;
    }
}