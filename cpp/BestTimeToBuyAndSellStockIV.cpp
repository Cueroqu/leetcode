//
// Created by Zhun Qu on 6/13/17.
//
#include <vector>
using namespace std;

/**
 * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 */

class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        if (prices.size() < 2) {
            return 0;
        }

        int i;
        if (k >= prices.size() / 2) {
            int result = 0;
            for (i = 0; i < prices.size() - 1; ++i) {
                if (prices[i+1]>prices[i]) result += prices[i+1]-prices[i];
            }
            return result;
        }

        int** dp = new int*[k+1];
        for (i = 0; i < k+1; ++i) {
            dp[i] = new int[prices.size()];
            memset(dp[i], 0, sizeof(int)*prices.size());
        }

        int j, localMax;
        for (i = 1; i < k+1; ++i) {
            localMax = dp[i-1][0] - prices[0];
            for (j = 1; j < prices.size(); ++j) {
                dp[i][j] = max(dp[i][j-1], prices[j] + localMax);
                localMax = max(localMax, dp[i-1][j] - prices[j]);
            }
        }
        int result = dp[k][prices.size()-1];
        for (i = 0; i < k+1; ++i) {
            delete[] dp[i];
        }
        delete[] dp;
        return result;
    }
};

int main() {
    Solution *s = new Solution();
    vector<int> prices {3,2,6,5,0,3};
    printf("%d\n", s->maxProfit(2, prices));
}

