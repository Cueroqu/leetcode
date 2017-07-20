/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import java.util.*;
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null) return null;
    	Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    	Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    	UndirectedGraphNode cur, head = new UndirectedGraphNode(node.label), tmp, real;
    	queue.add(node);
    	map.put(node.label, head);
    	while (!queue.isEmpty()) {
    		cur = queue.remove();
    		real = map.get(cur.label);
    		List<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();
    		real.neighbors = neighbors;
    		for (UndirectedGraphNode cn : cur.neighbors) {
    			tmp = map.get(cn.label);
    			if (tmp == null) {
    				tmp = new UndirectedGraphNode(cn.label);
    				map.put(cn.label, tmp);
    				queue.add(cn);
    			}
    			neighbors.add(tmp);
    		}
    	}
    	return head;
    }
}