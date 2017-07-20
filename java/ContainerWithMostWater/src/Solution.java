public class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
		int ret = -1, t;
		while (i < j) {
			t = Math.min(height[i], height[j]) * (j-i);
			if (ret < t) ret = t;
			if (height[i] < height[j]) ++i;
			else --j;
		}
		return ret;
    }
}