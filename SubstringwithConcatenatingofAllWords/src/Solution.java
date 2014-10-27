import java.util.*;

public class Solution {
	public HashMap<String, Integer> cnt = new HashMap<String, Integer>();
	int totallen, eachlen;
	
	public void Initialize(String[] L) {
		for (int i = 0; i < L.length; ++i) {
			if (cnt.containsKey(L[i])) cnt.put(L[i], cnt.get(L[i])+1);
			else cnt.put(L[i], 1);
		}
	}
	
	public List<Integer> findSubstring(String S, String[] L) {
    	List<Integer> ret = new ArrayList<Integer>();
    	int i, j, k, left;
    	if (L.length < 1) {
    		for (i = 0; i < S.length(); ++i) ret.add(i);
    		return ret;
    	}
    	Initialize(L);
    	eachlen = L[0].length();
    	totallen = L.length * eachlen;
    	HashMap<String, Integer> copy = null;
    	boolean modified = false;
    	String tmp, tmp2;
    	if (S.length() < totallen) return ret;
    	for (i = 0; i < eachlen; ++i) {
    		copy = (HashMap<String, Integer>) cnt.clone();
    		left = totallen;
    		modified = false;
    		for (j = i; j < S.length(); j += eachlen) {
    			if (j + left > S.length()) break;
    			tmp = S.substring(j, j+eachlen);
    			if (cnt.containsKey(tmp)) {
    				modified = true;
    				if (copy.get(tmp) > 0) {
    					copy.put(tmp, copy.get(tmp)-1);
    					left -= eachlen;
    					if (left == 0) {
    						ret.add(j - totallen + eachlen);
    						left += eachlen;
    						tmp2 = S.substring(j-totallen+eachlen, j-totallen+(eachlen<<1));
    						copy.put(tmp2, 1);
    					}
    				} else {
    					for (k = j - (totallen-left); k < j; k += eachlen) {
    						tmp2 = S.substring(k, k+eachlen);
    						if (tmp2.equals(tmp)) break;
    						copy.put(tmp2, copy.get(tmp2)+1);
    					}
    				}
    			} else if (modified) {
    				 copy = (HashMap<String, Integer>) cnt.clone();
    				 left = totallen;
    				 modified = false;
    			}
    		}
    	}
    	Collections.sort(ret);
    	return ret;
    }
	
	public static void main(String[] args) {
		String ss = "abaababbaba";
		String[] t = {"ba", "ab", "ab"};
		Solution s = new Solution();
		ArrayList<Integer> ret = (ArrayList<Integer>) s.findSubstring(ss, t);
		for (int i : ret) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}