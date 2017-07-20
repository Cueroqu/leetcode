import java.util.*;

public class Solution {
	
	public int dis(String a1, String a2) {
		int cnt = 0;
		for (int i = 0; i < a1.length(); ++i) {
			if (a1.charAt(i) != a2.charAt(i)) ++cnt;
		}
		return cnt;
	}
	
    public int ladderLength(String start, String end, Set<String> dict) {
    	if (start.length() != end.length()) return 0;
    	if (start.length() < 1) return 0;
    	if (dis(start, end) == 1) return 1;
    	Queue<String> record = new LinkedList<String>();
    	Map<String, Integer> ret = new HashMap<String, Integer>();
    	ret.put(start, 1);
    	record.add(start);
    	String cur, stmp;
    	int i;
    	char j, origin;
    	StringBuilder sb;
    	while (!record.isEmpty()) {
    		cur = record.remove();
    		sb = new StringBuilder(cur);
    		int tmp = ret.get(cur);
    		if (dis(cur, end) == 1) return tmp + 1;
    		for (i = 0; i < cur.length(); ++i) {
    			origin = sb.charAt(i);
    			for (j = 'a'; j <= 'z'; ++j) {
    				sb.setCharAt(i, j);
    				stmp = sb.toString();
    				if (dict.contains(stmp)) {  
    					dict.remove(stmp);
    					record.add(stmp);
    					ret.put(stmp, tmp+1);
    				}
    			}
    			sb.setCharAt(i, origin);
    		}
    	}
    	return 0;
    }
    
    public static void main(String[] args) {
    	Set<String> set = new HashSet<String>(Arrays.asList(new String[]{"hot","dot","dog","lot","log"}));
    	System.out.println((new Solution()).ladderLength("hit", "cog", set));
    }
}