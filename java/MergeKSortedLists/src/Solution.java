import java.util.*;

public class Solution {
	int[] heap;
	List<ListNode> rlists = new ArrayList<ListNode>();
	int size;
	
	public int GetParent(int n) {
		if (n == 0) return -1;
		else return (n-1)/2;
	}
	
	public int LeftChild(int n, int b) {
		int ret = n*2+1;
		if (ret >= b) return -1;
		return ret;
	}
	
	public int RightChild(int n, int b) {
		int ret = n*2+2;
		if (ret >= b) return -1;
		return ret;
	}
	
	public int MinThree(int i, int j, int k) {
		int ret = i;
		if (j >= 0 && rlists.get(heap[ret]).val > rlists.get(heap[j]).val) ret = j;
		if (k >= 0 && rlists.get(heap[ret]).val > rlists.get(heap[k]).val) ret = k;
		return ret;
	}
	
	public void swap(int i, int j) {
		int t = heap[i];
		heap[i] = heap[j];
		heap[j] = t;
	}
	
	public void Heapify(int n) {
		int l, r, min, index;
		for (int i = GetParent(n-1); i >= 0; --i) {
			for (index = i;;) {
				l = LeftChild(index, n);
				r = RightChild(index, n);
				min = MinThree(index, l, r);
				if (min != index) {
					swap(index, min);
					index = min;
				}
				else break;
			}
		}
	}
	
	public void Initialize(List<ListNode> lists) {
		heap = new int[lists.size()];
		int i, j;
		for (i = 0, j = 0; i < lists.size(); ++i) {
			if (lists.get(i) != null) {
				rlists.add(lists.get(i));
				heap[j] = j;
				++j;
			}
		}
		size = rlists.size();
		Heapify(rlists.size());
	}
	
	public void Update() {
		int index = 0, l, r, min;
		ListNode t = rlists.get(heap[0]);
		t = t.next;
		if (t == null) {
			rlists.set(heap[0], null);
			swap(0, size-1);
			--size;
			if (size == 0) return;
		} else rlists.set(heap[0], t);
		for (;;) {
			l = LeftChild(index, size);
			r = RightChild(index, size);
			min = MinThree(index, l, r);
			if (index != min) {
				swap(index, min);
				index = min;
			}
			else break;
		}
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
    	Initialize(lists);
    	if (size < 1) return null;
    	ListNode ret = new ListNode(rlists.get(heap[0]).val);
    	Update();
    	ListNode head = ret;
    	int k = 0;
    	for (;size > 0;) {
    		ListNode tmp = new ListNode(rlists.get(heap[0]).val);
    		ret.next = tmp;
    		ret = ret.next;
    		Update();
    	}
    	return head;
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
	
	class ListComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode l1, ListNode l2) {
			if (l1.val < l2.val) return -1;
			if (l1.val == l2.val) return 0;
			return 1;
		}
	}
	
	public ListNode mergeKLists2(List<ListNode> lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new ListComparator());
		Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
		for (int i = 0; i < lists.size(); ++i) {
			if (lists.get(i) == null) continue;
			queue.add(lists.get(i));
			map.put(lists.get(i), i);
		}
		if (queue.isEmpty()) return null;
		int index;
		ListNode tmp = queue.remove();
		index = map.get(tmp);
		ListNode ret = new ListNode(tmp.val), cur;
		cur = ret;
		lists.set(index, tmp.next);
		map.remove(tmp);
		if (tmp.next != null) {
			map.put(tmp.next, index);
			queue.add(tmp.next);
		}
		while (!queue.isEmpty()) {
			tmp = queue.remove();
			index = map.get(tmp);
			ListNode newnode = new ListNode(tmp.val);
			cur.next = newnode;
			cur = cur.next;
			lists.set(index, tmp.next);
			map.remove(tmp);
			if (tmp.next != null) {
				map.put(tmp.next, index);
				queue.add(tmp.next);
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
    	int[] x1 = {};
    	int[] x2 = {3,6,9};
    	int[] x3 = {4,7,10};
    	ArrayList<ListNode> tmp = new ArrayList<ListNode>();
    	ListNode l1 = ListNode.create(x1); tmp.add(l1);
    	ListNode l2 = ListNode.create(x2); tmp.add(l2);
    	ListNode l3 = ListNode.create(x3); tmp.add(l3);
    	s.PrintList(s.mergeKLists2(tmp));
	}
}