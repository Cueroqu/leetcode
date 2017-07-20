
public class Solution {
	/**
	 * Definition for singly-linked list.
	 */
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	 }
	 
	 public class Ans {
		 ListNode node;
		 int flag;
	 }
	
	 public Ans compute(int val) {
		 Ans ans = new Ans();
		 ListNode sub = new ListNode(val);
		 ans.flag = sub.val / 10;
		 sub.val = sub.val % 10;
		 ans.node = sub;
		 return ans;
	 }
	 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Ans ans = compute(l1.val + l2.val);
        ListNode ret = ans.node, index;
        index = ret;
        while (l1.next != null && l2.next != null) {
        	l1 = l1.next;
        	l2 = l2.next;
        	ans = compute(l1.val + l2.val + ans.flag);
        	index.next = ans.node;
        	index = index.next;
        }
        ListNode left = (l1.next == null) ? l2 : l1;
        while (left.next != null) {
        	left = left.next;
        	ans = compute(left.val + ans.flag);
        	index.next = ans.node;
        	index = index.next;
        }
        if (ans.flag == 1) {
        	ListNode tail = new ListNode(ans.flag);
        	index.next = tail;
        }
        return ret;
    }
    
    public ListNode create(int[] x) {
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
    	System.out.format("%d", node.val);
    	while (node.next != null) {
    		node = node.next;
    		System.out.format("->%d", node.val);
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] x1 = {2,4,3};
    	int[] x2 = {5,6,4};
    	ListNode l1 = s.create(x1);
    	ListNode l2 = s.create(x2);
    	s.PrintList(s.addTwoNumbers(l1, l2));
    }
}