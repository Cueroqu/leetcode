import java.util.*;

public class Solution {
	public void postOrderTraverse(TreeNode root) {
		TreeNode cur = root, lastvisited = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (cur != null || stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.peek();
				if (cur.right != null && cur.right != lastvisited) {
					cur = cur.right;
				} else {
					cur = stack.pop();
					System.out.println(cur.val);
					lastvisited = cur;
					cur = null;
				}
			}
		}
	}
}
