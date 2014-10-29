/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Queue<RandomListNode> queue = new LinkedList<RandomListNode>();
        Map<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        queue.add(head);
        RandomListNode cur, gen, tmp, ret = new RandomListNode(head.label);
        map.put(ret.label, ret);
        while (!queue.isEmpty()) {
            cur = queue.remove();
            gen = map.get(cur.label);
            if (cur.next != null) {
                tmp = map.get(cur.next.label);
                if (tmp == null) {
                    tmp = new RandomListNode(cur.next.label);
                    map.put(tmp.label, tmp);
                    queue.add(cur.next);
                }
                gen.next = tmp;
            }
            if (cur.random != null) {
                tmp = map.get(cur.random.label);
                if (tmp == null) {
                    tmp = new RandomListNode(cur.random.label);
                    map.put(tmp.label, tmp);
                    queue.add(cur.random);
                }
                gen.random = tmp;
            }
        }
        return ret;
    }
}