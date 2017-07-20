import java.util.*;

public class Solution {
    public String minWindow(String S, String T) {
    	int start = 0, end = -1, i, minstart = Integer.MIN_VALUE, minend = -1, tchcnt = 0, state = 0;
    	Map<Character, Integer> tcnt = new HashMap<Character, Integer>();
    	for (i = 0; i < T.length(); ++i) {
    		tcnt.put(T.charAt(i), tcnt.containsKey(T.charAt(i)) ? tcnt.get(T.charAt(i)) - 1 : -1);
    	}
    	tchcnt = tcnt.size();
    	if (tchcnt == 0 || S.length() < 1) return "";
    	for (;;) {
    		switch (state) {
    		case 0:
    			while (tchcnt > 0 && end < S.length()-1) {
    				end++;
    				if (tcnt.containsKey(S.charAt(end))) {
    					tcnt.put(S.charAt(end), tcnt.get(S.charAt(end))+1);
    					if (tcnt.get(S.charAt(end)) == 0) {
    						tchcnt--;
    					}
    				}
    			}
    			if (tchcnt == 0 && (end-start)<(minend-minstart)) {
    				minend = end;
    				minstart = start;
    			}
    			//System.out.format("state = %d, start = %d, end = %d, minstart = %d, minend = %d\n", state, start, end, minstart, minend);
    			state = 1;
    			break;
    		case 1:
    			while (tchcnt == 0 && start <= end) {
    				if (tcnt.containsKey(S.charAt(start))) {
    					tcnt.put(S.charAt(start), tcnt.get(S.charAt(start))-1);
    					if (tcnt.get(S.charAt(start)) == -1) {
    						tchcnt++;
    					}
    				}
    				++start;
    				if (tchcnt == 0 && (end-start)<(minend-minstart)) {
    					minend = end;
    					minstart = start;
    				}
    			}
    			state = 0;
    			break;
    		}
    		if (state == 0 && end == S.length()-1) {
    			if (minend < 0) return "";
    			else return S.substring(minstart, minend+1);
    		}
    	}
    }
    
    public void print(Map<Character, Integer> cnt) {
    	for (Character c : cnt.keySet()) {
    		System.out.format("%c -> %d\n", c, cnt.get(c));
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	System.out.println((new Solution()).minWindow("A", "AA"));
    }
}