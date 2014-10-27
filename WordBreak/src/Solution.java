import java.util.*;
public class Solution {
	
	public boolean solve(boolean[][] mark, int[] record, String s, int start, Set<String> dict) {
		if (start >= s.length()) return true;
		if (record[start] > 0) return record[start] == 1;
		if (mark[start][s.length()-1]) {
			record[start] = 1;
			return true;
		}
		for (int i = start; i < s.length()-1; ++i) {
			if (mark[start][i]) {
				record[i+1] = solve(mark, record, s, i+1, dict) ? 1 : 2;
				if (record[i+1] == 1) {
					record[start] = 1;
					return true;
				}
			}
		}
		record[start] = 2;
		return false;
	}
	
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[][] mark = new boolean[s.length()][s.length()];
        int[] record = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
        	sb.setLength(0);
        	for (int j = i; j < s.length(); ++j) {
        		sb.append(s.charAt(j));
        		mark[i][j] = dict.contains(sb.toString());
        	}
        }
        solve(mark, record, s, 0, dict);
        return mark[0][s.length()-1] || record[0] == 1;
    }
    
    public static void main(String[] args) {
    	Set<String> set = new HashSet<String>(Arrays.asList(new String[]{"a", "b"}));
    	System.out.println((new Solution()).wordBreak("ab", set));
    }
}