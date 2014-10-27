public class Solution {
    public int jump(int[] A) {
    	int last = 0, curr = 0, ret = 0;
    	for (int i = 0; i < A.length; ++i) {
    		if (i > last) {
    			last = curr;
    			++ret;
    		}
    		curr = Math.max(curr, i+A[i]);
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
    	int[] x = {2,3,1,1,4};
    	System.out.println((new Solution()).jump(x));
    }
}