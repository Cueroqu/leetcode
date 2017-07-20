import java.util.*;

public class Solution {
	public int threeSumClosest(int[] num, int target) {
    	Arrays.sort(num);
        int ret = num[0]+num[1]+num[2], j, k;
        int dis = Math.abs(ret - target), sum = ret;
        for (int i = 0; i < num.length - 2; ++i) {
        	j = i+1;
        	k = num.length - 1;
        	while (j < k) {
        		sum = num[i] + num[j] + num[k];
        		if (Math.abs(sum - target) < dis) {
        			ret = sum;
        			dis = Math.abs(sum - target);
        			if (ret == target) return ret;
        		}
        		if (sum <= target) ++j;
        		else if (sum > target) --k;
        	}
        }
        return ret;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] a = {0,1,2};
		System.out.println(s.threeSumClosest(a, 3));
	}
}
