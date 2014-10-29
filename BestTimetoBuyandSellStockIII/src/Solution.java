public class Solution {
    public int maxProfit(int[] prices) {
        int[][] profits = new int[2][prices.length+1];
        if (prices.length < 2) return 0;
        int maxv = 0, max = 0, min = Integer.MAX_VALUE;
        profits[0][0] = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (min > prices[i]) min = prices[i];
            else if (prices[i] - min > maxv) maxv = prices[i] - min;
            profits[0][i+1] = maxv;
        }
        maxv = 0; max = 0; min = Integer.MAX_VALUE;
        profits[1][prices.length] = 0;
        for (int i = prices.length-1; i >= 0; --i) {
            if (max < prices[i]) max = prices[i];
            else if (max - prices[i] > maxv) maxv = max - prices[i];
            profits[1][i] = maxv;
        }
        max = profits[0][0] + profits[1][0];
        for (int i = 1; i < profits[0].length; ++i) {
            if (max < profits[0][i] + profits[1][i]) max = profits[0][i] + profits[1][i];
        }
        return max;
    }
}