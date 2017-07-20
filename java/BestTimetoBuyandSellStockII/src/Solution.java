public class Solution {
    public int maxProfit(int[] prices) {
        int ret = 0, max = -1, min = Integer.MAX_VALUE;
        if (prices.length < 2) return 0;
        boolean getmax = true;
        for (int i = prices.length - 1; i >= 0; --i) {
            if (getmax) {
                if (max < prices[i]) {
                    max = prices[i];
                } else {
                    getmax = false;
                    min = prices[i];
                }
            } else {
                if (min > prices[i]) {
                    min = prices[i];
                } else {
                    getmax = true;
                    ret += (max - min);
                    max = prices[i];
                    min = Integer.MAX_VALUE;
                }
            }
        }
        if (max > min) ret += max - min;
        return ret;
    }
}