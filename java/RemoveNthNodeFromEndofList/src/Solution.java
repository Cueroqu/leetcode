/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import java.util.*;

public class Solution {
	
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
		
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode cur = head;
        list.add(cur);
        while (cur.next != null) {
        	cur = cur.next;
        	list.add(cur);
        }
        if (n == list.size()) return head.next;
        ListNode nm1thfb = list.get(list.size() - n - 1);
        if (n == 0) nm1thfb.next = head;
        else nm1thfb.next = nm1thfb.next.next;
        return head;
    }
    
    public ListNode removeNthFromEnd2(ListNode head, int n) {
    	ListNode fake = new ListNode(0), pre = fake, cur = head, probe = head;
    	fake.next = head;
    	while (--n > 0) {
    		probe = probe.next;
    	}
    	while (probe.next != null) {
    		pre = pre.next;
    		cur = cur.next;
    		probe = probe.next;
    	}
    	pre.next = cur.next;
    	return fake.next;
    }
}