import java.io.*;
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
public class Solution {
	// merge sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head, pre = null, tmp;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        head = sortList(head);
        slow = sortList(slow);
        ListNode fake = new ListNode(0);
        pre = fake;
        fake.next = head;
        while (pre.next != null && slow != null) {
            if (slow.val < pre.next.val) {
                tmp = slow.next;
                slow.next = pre.next;
                pre.next = slow;
                pre = slow;
                slow = tmp;
            } else pre = pre.next;
        }
        if (slow != null) pre.next = slow;
        return fake.next;
    }
    
    // quick sort
    ListNode GetTail(ListNode head, ListNode flag) {
    	if (head == null) return null;
    	while (head.next != flag) head = head.next;
    	return head;
    }
    
    public ListNode sortList2(ListNode head) {
    	return Quicksort(head, GetTail(head, null));
    }
    
    class ListNodeTriple {
    	ListNode pivot;
    	ListNode head;
    	ListNode tail;
    	public ListNodeTriple(ListNode h, ListNode t, ListNode p) {
    		head = h;
    		tail = t;
    		pivot = p;
    	}
    }
    
    public ListNode Quicksort(ListNode head, ListNode tail) {
    	if (head == tail) return head;
    	if (head.next == tail) {
    		if (head.val <= tail.val) return head;
    		tail.next = head;
    		head.next = null;
    		return tail;
    	}
    	int val = head.val;
    	ListNode cur = head;
    	while (cur.next != null) {
    		if (cur.next.val != val) break;
    		cur = cur.next;
    	}
    	if (cur == tail) return head;
    	ListNodeTriple triple = Partition(head, tail);
    	ListNode newHead = triple.pivot;
    	if (triple.pivot != triple.head) {
    		ListNode tmp = GetTail(triple.head, triple.pivot);
    		tmp.next = null;
    		newHead = Quicksort(triple.head, tmp);
    		tmp = GetTail(newHead, null);
    		tmp.next = triple.pivot;
    	}
    	if (triple.pivot != triple.tail) {
    		triple.pivot.next = Quicksort(triple.pivot.next, triple.tail);
    	}
    	return newHead;
    }
    
    public ListNodeTriple Partition(ListNode head, ListNode tail) {
    	ListNode pivot = tail, cur = head, pre = null;
    	ListNodeTriple ret = new ListNodeTriple(null, tail, pivot);
    	while (cur != pivot) {
    		if (cur.val < pivot.val) {
    			if (ret.head == null) ret.head = cur;
    			pre = cur;
    			cur = cur.next;
    		} else {
    			ListNode tmp = cur.next;
    			cur.next = null;
    			tail.next = cur;
    			tail = cur;
    			if (pre != null) pre.next = tmp;
    			cur = tmp;
    		}
    	}
    	if (ret.head == null) ret.head = pivot;
    	ret.tail = tail;
    	return ret;
    }
    
    public static void main(String[] args) {
//    	ListNode head = ListNode.create(new int[]{4,2,1,3});
    	ListNode head = null;
    	try {
    		BufferedReader in = new BufferedReader(new FileReader("src/data.in"));
    		String str;
    		while ((str = in.readLine()) != null) {
    			head = ListNode.create(str);
    		}
    		in.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	Solution s = new Solution();
    	ListNode ret = s.sortList2(head);
    	while (ret != null) {
    		System.out.format("%d ", ret.val);
    		ret = ret.next;
    	}
    }
}