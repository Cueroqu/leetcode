
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
    
    public static void PrintList(ListNode node) {
    	if (node == null) return;
    	System.out.format("%d", node.val);
    	while (node.next != null) {
    		node = node.next;
    		System.out.format("->%d", node.val);
    	}
    	System.out.println();
    }
}