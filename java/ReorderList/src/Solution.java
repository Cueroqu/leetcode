/**
 * Definition for singly-linked list.
 * class ListNode {
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
    public void reorderList(ListNode head) {
    	List<ListNode> ret = new ArrayList<ListNode>();
    	ListNode cur = head;
    	while (cur != null) {
    		ret.add(cur);
    		cur = cur.next;
    	}
    	int start = 0, end = ret.size() - 1;
    	ListNode tmp;
    	while (start < end) {
    		ret.get(start).next = ret.get(end);
    		if (start < end - 1) {
    			ret.get(end).next = ret.get(start+1);
    		} else {
    			ret.get(end).next = null;
    		}
    		++start; --end;
    		if (start == end) {
    			ret.get(start).next = null;
    			break;
    		}
    	}
    }
}