import java.util.*;
public class Solution {
	public int dis(String a1, String a2) {
		int cnt = 0;
		for (int i = 0; i < a1.length(); ++i) {
			if (a1.charAt(i) != a2.charAt(i)) ++cnt;
		}
		return cnt;
	}
	
	public void dfs(List<List<String>> ret, String[] record, String cur, Map<String, List<String>> parents, int level) {
		if (level == record.length) {
			List<String> list = new ArrayList<String>();
			for (int i = record.length - 1; i >= 0; --i) {
				list.add(record[i]);
			}
			ret.add(list);
			return;
		}
		for (String parent : parents.get(cur)) {
			record[level-1] = parent;
			dfs(ret, record, parent, parents, level+1);
		}
	}
	
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> ret = new ArrayList<List<String>>();
        if (start.length() != end.length() || start.length() < 1) return ret;
        Queue<String> queue = new LinkedList<String>();
        Map<String, Integer> length = new HashMap<String, Integer>();
        Map<String, List<String>> parents = new HashMap<String, List<String>>();
        queue.add(start);
        length.put(start, 1);
        String cur, stmp;
        StringBuilder sb;
        int ltmp, minl = -1;
        List<String> list = new ArrayList<String>();
        parents.put(end, list);
        int i;
        char j, origin;
        while (!queue.isEmpty()) {
        	cur = queue.remove();
        	ltmp = length.get(cur);
        	if (minl >= 0 && ltmp >= minl) break;
        	if (dis(cur, end) == 1) {
        		parents.get(end).add(cur);
        		minl = ltmp + 1;
        		continue;
        	}
        	sb = new StringBuilder(cur);
        	for (i = 0; i < cur.length(); ++i) {
        		origin = sb.charAt(i);
        		for (j = 'a'; j <= 'z'; ++j) {
        			sb.setCharAt(i, j);
        			stmp = sb.toString();
        			if (dict.contains(stmp)) {
        				dict.remove(stmp);
        				queue.add(stmp);
        				length.put(stmp, ltmp+1);
        				list = new ArrayList<String>();
        				list.add(cur);
        				parents.put(stmp, list);
        			} else if (length.containsKey(stmp) && length.get(stmp)-1==ltmp) {
        				parents.get(stmp).add(cur);
        			}
        		}
        		sb.setCharAt(i, origin);
        	}
        }
        if (minl > 0) {
	        String[] record = new String[minl];
	    	record[minl-1] = start;
	    	record[0] = end;
	    	dfs(ret, record, end, parents, 2);
        }
    	return ret;
    }
    
    public void print(List<List<String>> ret) {
    	for (List<String> list : ret) {
    		for (String s : list) {
    			System.out.print(s + " ");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
    	
    	Solution s = new Solution();
    	Set<String> set = new HashSet<String>(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
    	s.print(s.findLadders("hit", "cog", set));
    }
}