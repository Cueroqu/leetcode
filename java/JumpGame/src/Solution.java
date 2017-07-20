public class Solution {
    public boolean canJump(int[] A) {
    	int cur = 0;
    	for (int i = 0; i < A.length; ++i) {
    		if (i > cur) return false;
    		cur = Math.max(cur, i+A[i]);
    		if (cur >= A.length-1) return true;
    	}
    	return true;
    }
}