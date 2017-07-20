public class Solution {
	
	public ListNode Reverse(ListNode node, int k) {
		ListNode cur = node, tmp, origin;
		int i;
		for (i = 0; i < k; ++i) {
			if (cur.next == null) return node.next;
			cur = cur.next;
		}
		origin = node;
		cur = node.next;
		for (i = 0; i < k; ++i) {
			tmp = cur.next;
			cur.next = origin;
			origin = cur;
			cur = tmp;
		}
		node.next.next = cur;
		return origin;
	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
    	ListNode dummy = new ListNode(0), cur, origin;
    	dummy.next = origin = head;
    	cur = dummy;
    	while (cur.next != null) {
    		origin = cur.next;
    		cur.next = Reverse(cur, k);
    		if (cur.next == origin) break;
    		else cur = origin;
    	}
    	return dummy.next;
    }
    
    public static void main(String args[]) {
    	int[] x = {1,2,3,4,5};
    	Solution s = new Solution();
    	ListNode node = ListNode.create(x);
    	ListNode.PrintList(s.reverseKGroup(node, 3));
    }
}