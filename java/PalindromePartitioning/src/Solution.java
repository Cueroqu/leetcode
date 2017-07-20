import java.util.*;
public class Solution {
	
	public int[][] mark;
	
	public boolean isPalindrome(String sb, int start, int end) {
		if (mark[start][end] > 0) return mark[start][end] == 1;
		int head = start, tail = end;
		while (head < tail) {
			if (sb.charAt(head++) != sb.charAt(tail--)) {
				mark[start][end] = 2;
				return false;
			}
		}
		mark[start][end] = 1;
		return true;
	}
	
	public void solve(List<List<String>> ret, List<Integer> list, String s, int index) {
		if (index == s.length()) {
			List<String> tmp = new ArrayList<String>();
			tmp.add(s.substring(0, list.get(0)+1));
			for (int i = 1; i < list.size(); ++i) {
				tmp.add(s.substring(list.get(i-1)+1, list.get(i)+1));
			}
			ret.add(tmp);
			return;
		}
		
		for (int i = index; i < s.length(); ++i) {
			if (isPalindrome(s, index, i)) {
				list.add(i);
				solve(ret, list, s, i+1);
				list.remove(list.size()-1);
			}
		}
	}
	
    public List<List<String>> partition(String s) {
    	List<List<String>> ret = new ArrayList<List<String>>();
        if (s.length() < 1) return ret;
        mark = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) mark[i][i] = 1;
        List<Integer> cur = new ArrayList<Integer>();
        solve(ret, cur, s, 0);
        return ret;
    }
    
    public void print(List<List<String>> lists) {
    	for (List<String> list : lists) {
    		for (String s : list) {
    			System.out.print(s + " ");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	s.print(s.partition("aab"));
    }
}