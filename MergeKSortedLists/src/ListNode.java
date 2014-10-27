
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
    public static ListNode create(int[] x) {
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
}
 