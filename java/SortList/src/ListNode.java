
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
    public static ListNode create(String s) {
    	String[] tmp = s.split(",");
    	ListNode ret = new ListNode(Integer.parseInt(tmp[0])), index = ret;
    	for (int i = 1; i < tmp.length; ++i) {
    		index.next = new ListNode(Integer.parseInt(tmp[i]));
    		index = index.next;
    	}
    	return ret;
    }
}
 