/**
 * Created by zhun.qu on 6/6/17.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1, sum;
        int[] ans = new int[2];
        while (i < j) {
            sum = numbers[i] + numbers[j];
            if (sum < target) {
                ++i;
            } else if (sum > target) {
                --j;
            } else {
                ans[0] = i + 1;
                ans[1] = j + 1;
                break;
            }
        }
        return ans;
    }
}
