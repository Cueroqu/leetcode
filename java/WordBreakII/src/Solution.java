import java.util.*;
public class Solution {
	
	public int solve(List<String> ans, List<String> cur, boolean[][] mark, int[] record, String s, int start) {
		if (start >= s.length()) {
			StringBuilder sb = new StringBuilder();
			sb.append(cur.get(0));
			for (int i = 1; i < cur.size(); ++i) {
				sb.append(" " + cur.get(i));
			}
			ans.add(sb.toString());
			return 1;
		}
		if (record[start] == 2) return 2;
		
		int j;
		for (j = start; j < s.length(); ++j) {
			if (mark[start][j]) {
				cur.add(s.substring(start, j+1));
				if ((record[j+1] = solve(ans, cur, mark, record, s, j+1)) == 1)
					record[start] = 1;
				cur.remove(cur.size()-1);
			}
		}
	
		if (record[start] == 0) record[start] = 2;
		return record[start];
	}
	
    public List<String> wordBreak(String s, Set<String> dict) {
        boolean[][] mark = new boolean[s.length()][s.length()];
        int[] record = new int[s.length()+1];
        record[s.length()] = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
        	sb.setLength(0);
        	for (int j = i; j < s.length(); ++j) {
        		sb.append(s.charAt(j));
        		mark[i][j] = dict.contains(sb.toString());
        	}
        }
        List<String> anss = new ArrayList<String>();
        List<String> cur = new ArrayList<String>();
        if (s.length() > 0)
        	solve(anss, cur, mark, record, s, 0);
        return anss;
    }
    
    public List<String> wordBreak2(String s, Set<String> dict) {
    	Map<Integer, List<String>> validWordBreaks = new HashMap<Integer, List<String>>();
    	List<String> list = new ArrayList<String>();
    	list.add("");
    	validWordBreaks.put(s.length(), list);
    	int i, j;
    	String tmp;
    	for (i = s.length()-1; i >= 0; --i) {
    		list = new ArrayList<String>();
    		for (j = i+1; j <= s.length(); ++j) {
    			tmp = s.substring(i, j);
    			if (dict.contains(tmp)) {
    				for (String word : validWordBreaks.get(j)) {
    					list.add(tmp + (word.length() == 0 ? "" : " ") + word);
    				}
    			}
    		}
    		validWordBreaks.put(i, list);
    	}
    	return validWordBreaks.get(0);
    }
    
    public static void print(List<String> ret) {
    	for (String s : ret) {
    		System.out.println(s);
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	//Set<String> set = new HashSet<String>(Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"}));
    	Set<String> set = new HashSet<String>();
    	Solution.print((new Solution()).wordBreak2("a", set));
    }
}