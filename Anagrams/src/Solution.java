import java.util.*;
public class Solution {
	
	public String countAlphas(String str) {
		int[] cnt = new int[26];
		for (int i = 0; i < str.length(); ++i) {
			++cnt[str.charAt(i)-'a'];
		}
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < 26; ++i) {
			if (cnt[i] > 0) {
				ret.append(cnt[i]);
				ret.append((char)('a'+i));
			}
		}
		return ret.toString();
	}
	
    public List<String> anagrams(String[] strs) {
    	String[] cnts = new String[strs.length];
    	List<String> ret = new ArrayList<String>();
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	for (int i = 0; i < strs.length; ++i) {
    		cnts[i] = countAlphas(strs[i]);
    	}
    	for (int i = 0; i < strs.length; ++i) {
    		if (map.containsKey(cnts[i])) { 
    			ret.add(strs[i]);
    			if (map.get(cnts[i]) >= 0) {
    				ret.add(strs[map.get(cnts[i])]);
    				map.put(cnts[i], -1);
    			}
    		} else map.put(cnts[i], i);
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
    	String[] x = {"abcfasfewa"};
    	List<String> ret = (new Solution()).anagrams(x);
    	System.out.println(ret.size());
    	for (int i = 0; i < ret.size(); ++i) {
    		
    	}
    }
}