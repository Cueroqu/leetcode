public class Solution {
	
	public void swap(ListNode node, ListNode pre) {
		ListNode tmp = node.next;
		node.next = tmp.next;
		tmp.next = node;
		if (pre !=  null) pre.next = tmp;
	}
	
    public ListNode swapPairs(ListNode head) {
    	ListNode cur, ret, origin;
    	if (head == null || head.next == null) return head;
    	ret = head.next;
    	cur = ret.next;
    	origin = head;
    	swap(head, null);
    	while (cur != null) {
    		if (cur.next != null) {
    			swap(cur, origin);
    			origin = cur;
    			cur = cur.next;
    		} else break;
    	}
    	return ret;
    }
    
    public ListNode create(int[] x) {
    	if (x.length < 1) return null;
      	 ListNode ret = new ListNode(x[0]);
      	 ListNode index = ret;
      	 for (int i = 1; i < x.length; ++i) {
      		 ListNode sub = new ListNode(x[i]);
      		 index.next = sub;
      		 index = index.next;
      	 }
      	 return ret;
       }
    
    public void PrintList(ListNode node) {
    	if (node == null) return;
    	System.out.format("%d", node.val);
    	while (node.next != null) {
    		node = node.next;
    		System.out.format("->%d", node.val);
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	int[] x = {1,2};
    	Solution s = new Solution();
    	ListNode node = s.create(x);
    	s.PrintList(s.swapPairs(node));
    }
}