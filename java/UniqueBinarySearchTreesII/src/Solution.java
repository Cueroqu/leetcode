/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    
    public List<TreeNode> generateTree(int head, int tail) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if (head > tail) {
            ret.add(null);
            return ret;
        }
        List<TreeNode> leftsubtrees, rightsubtrees;
        int i, j, k;
        for (i = head; i <= tail; ++i) {
            leftsubtrees = generateTree(head, i-1);
            rightsubtrees = generateTree(i+1, tail);
            for (j = 0; j < leftsubtrees.size(); ++j) {
                for (k = 0; k < rightsubtrees.size(); ++k) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = leftsubtrees.get(j);
                    tmp.right = rightsubtrees.get(k);
                    ret.add(tmp);
                }
            }
        }
        return ret;
    }
    
    public List<TreeNode> generateTrees(int n) {
        return generateTree(1, n);
    }
}