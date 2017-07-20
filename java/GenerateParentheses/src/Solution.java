import java.util.*;
public class Solution {
	public void solve(ArrayList<String> list, int left, int right, String sb) {
		if (right == 0) {
			list.add(sb.toString());
			return;
		}
		if (left < right) {
			solve(list, left, right-1, sb+')');
		}
		if (left > 0) {
			solve(list, left-1, right, sb+'(');
		}
	}
	
    public List<String> generateParenthesis(int n) {
    	ArrayList<String> list = new ArrayList<String>();
    	solve(list, n, n, "");
    	return list;
    }
    public static void main(String[] args) {
    	Solution s = new Solution();
    	ArrayList<String> as = (ArrayList<String>) s.generateParenthesis(3);
    	for (int i = 0; i < as.size(); ++i) {
    		System.out.print(as.get(i) + ", ");
    	}
    	System.out.println();
    }
}