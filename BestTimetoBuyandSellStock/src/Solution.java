public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxp = -1, maxv = -1;
        for (int i = prices.length - 1; i >= 0; --i) {
            if (maxv < prices[i]) maxv = prices[i];
            if (maxv - prices[i] > maxp) maxp = maxv - prices[i];
        }
        return maxp;
    }
}