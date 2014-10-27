public class Solution {
    public int findMin(int[] num) {
    	int l = 0, r = num.length-1, m, om;
    	while (l < r-1) {
    		om = m = (l+r) >> 1;
    		while (m < r && num[m] == num[m-1]) m++;
    		if (num[m] < num[m-1]) return num[m];
    		if (m == r) r = om;
    		else if (num[m] == num[r]) --r;
    		else if (num[m] < num[r]) r = Math.min(om, m-1);
    		else l = m+1;
    	}
    	return Math.min(num[l], num[r]);
    }
    
    public int findMin2(int[] num) {
    	int l = 0, r = num.length - 1, m;
    	while (l < r) {
    		m = (l+r) >> 1;
    		if (num[r] < num[m]) l = m+1;
    		else if (num[r] > num[m] || num[l] != num[m]) r = m;
    		else {
    			++l;
    			--r;
    		}
    	}
    	return num[r];
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.findMin(new int[]{1,10,10,10,10}));
    }
}