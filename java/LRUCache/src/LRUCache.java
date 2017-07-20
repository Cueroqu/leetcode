import java.util.*;

/* 查看使用LinkedHashMap的实现 */

public class LRUCache {
    
	class Pair {
		int key;
		int value;
		long time;
		Pair(int k, int v, long t) {
			key = k;
			value = v;
			time = t;
		}
		
		@Override
		public String toString() {
			return String.format("[key = %d, value =%d]", key, value);
		}
	}
	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	Map<Integer, Integer> position = new HashMap<Integer, Integer>();
	Pair[] heap;
	int capacity = 0;
	long timestamp = 0;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
        heap = new Pair[this.capacity];
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
        	heap[position.get(key)].time = this.timestamp++;
        	Underflow(position.get(key));
        	return map.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
        	heap[position.get(key)].value = value;
        	heap[position.get(key)].time = this.timestamp++;
        	map.put(key, value);
        	Underflow(position.get(key));
        } else {
        	Pair tmp = new Pair(key, value, this.timestamp++);
        	if (map.size() < this.capacity) {
        		heap[map.size()] = tmp;
        		position.put(key, map.size());
        		map.put(key, value);
        	} else {
        		map.put(key, value);
        		map.remove(heap[0].key);
        		position.put(key, 0);
        		position.remove(heap[0].key);
        		heap[0] = tmp;
        		Underflow(0);
        	}
        }
    }
    
    public void Underflow(int pos) {
    	int li, ri;
    	long lv, rv;
    	for (;;) {
    		li = getLeft(pos);
    		if (li < 0 || li >= map.size()) {
//    			System.out.println("Underflow: ");
//    			print();
    			position.put(heap[pos].key, pos);
    			return;
    		}
    		lv = heap[li].time;
    		
    		ri = getRight(pos);
    		if (ri < 0 || ri >= map.size()) rv = Long.MAX_VALUE;
    		else rv = heap[ri].time;
    		
    		if (lv > rv) {
    			li = ri;
    			lv = rv;
    		}
    		
    		if (heap[pos].time < lv) {
//    			System.out.println("Underflow: ");
//    			print();
    			position.put(heap[pos].key, pos);
    			return;
    		}
    		swap(pos, li);
    		position.put(heap[pos].key, pos);
    		pos = li;
    	}
    }
    
    public void swap(int a, int b) {
    	Pair t = heap[a];
    	heap[a] = heap[b];
    	heap[b] = t;
    }
    
    public int getParent(int pos) {
    	if (pos == 0) return -1;
    	return (pos-1) >> 1;
    }
    
    public int getLeft(int pos) {
    	return pos*2+1;
    }
    
    public int getRight(int pos) {
    	return pos*2+2;
    }
    
    public void print() {
    	for (int i = 0; i < heap.length; ++i) {
    		if (heap[i] == null) break;
    		System.out.println(heap[i]);
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache(2);
    	cache.set(2, 1);
    	cache.set(2, 2);
    	System.out.println(cache.get(2));
    	cache.set(1, 1);
    	cache.set(4, 1);
    	System.out.println(cache.get(2));
    }
}