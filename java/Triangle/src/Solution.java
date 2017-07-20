import java.util.*;
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if (triangle.size() == 0) return 0;
        int[] cnt = new int[triangle.size()];
        int i, j, ret;
        cnt[0] = triangle.get(0).get(0);
        for (i = 1; i < triangle.size(); ++i) {
        	cnt[i] = cnt[i-1] + triangle.get(i).get(i);
        	for (j = i-1; j > 0; --j) {
        		cnt[j] = Math.min(cnt[j], cnt[j-1]) + triangle.get(i).get(j);
        	}
        	cnt[0] = cnt[0] + triangle.get(i).get(0);
        }
        for (i = 1, ret = cnt[0]; i < cnt.length; ++i) ret = Math.min(ret, cnt[i]);
        return ret;
    }
}