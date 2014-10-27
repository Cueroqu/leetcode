import java.math.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	int[] pos = new int[256];
    	int i, cnt = 0, max = 0;
    	for (i = 0; i < pos.length; ++i) pos[i] = -1;
    	for (i = 0; i < s.length(); ++i) {
    		if (pos[s.charAt(i)] >= 0) {
    			// for input "hddh"
    			// when i == 2, cnt = i - pos[s.charAt(i)]
    			// when i == 3, cnt = cnt+1;
    			cnt = Math.min(i - pos[s.charAt(i)], cnt + 1);
    			pos[s.charAt(i)] = i;
    		} else {
    			++cnt;
    			pos[s.charAt(i)] = i;
    		}
    		if (max < cnt) max = cnt;
    	}
    	return max;
    }
    
    public static void main(String args[]) {
    	Solution s = new Solution();
    	String ss = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
    	System.out.println(ss.length());
    	System.out.println(s.lengthOfLongestSubstring(ss));
    }
}