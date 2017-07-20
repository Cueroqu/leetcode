/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        parentStack.add(root);
        TreeNode cur = root, lastvisited = null;
        int ret = Integer.MIN_VALUE, nv, left, right;
        while (cur != null || !parentStack.empty()) {
        	if (cur != null) {
        		parentStack.push(cur);
        		cur = cur.left;
        	} else {
        		TreeNode tmp = parentStack.peek();
        		if (tmp.right != null && tmp.right != lastvisited) {
        			cur = tmp.right;
        		} else {
        			left = (map.get(tmp.left) == null) ? 0 : map.get(tmp.left);
        			if (left < 0) left = 0;
        			right = (map.get(tmp.right) == null) ? 0 : map.get(tmp.right); 
        			if (right < 0) right = 0;
        			nv = tmp.val + Math.max(left, right);
        			map.put(tmp, nv);
        			if (tmp.val + left + right > ret) ret = tmp.val + left + right;
        			parentStack.pop();
        			lastvisited = tmp;
        		}
        	}
        }
        return ret;
    }
    
    class ValuePair {
        int treevalue;
        int pathvalue;
        public ValuePair() {
            treevalue = pathvalue = Integer.MIN_VALUE;
        }
    }
    
    public ValuePair solve(TreeNode root) {
        ValuePair vp = new ValuePair();
        if (root == null) return vp;
        ValuePair leftvp = solve(root.left);
        ValuePair rightvp = solve(root.right);
        vp.pathvalue = Math.max(leftvp.pathvalue, rightvp.pathvalue);
        vp.pathvalue = Math.max((vp.pathvalue<0?0:vp.pathvalue)+root.val, root.val);
        vp.treevalue = (leftvp.pathvalue < 0 ? 0 : leftvp.pathvalue) + (rightvp.pathvalue < 0 ? 0 : rightvp.pathvalue) + root.val;
        System.out.println(vp.treevalue);
        vp.treevalue = Math.max(Math.max(leftvp.treevalue, rightvp.treevalue), vp.treevalue);
        return vp;
    }
    
    public int maxPathSum2(TreeNode root) {
        if (root == null) return 0;
        ValuePair vp = solve(root);
        return vp.treevalue;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	TreeNode root = new TreeNode(2);
    	TreeNode right = new TreeNode(-1);
    	root.right = right;
    	System.out.println(s.maxPathSum2(root));
    }
}