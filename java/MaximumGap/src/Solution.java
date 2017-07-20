/**
 * Created by zhun.qu on 6/6/17.
 */
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        } else if (nums.length == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        int min = nums[0], max = nums[0], gapNum = nums.length - 1, numIndex;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        double gapSize = (double)(max - min + 1) / (double)gapNum;
        int[] bucketMin = new int[gapNum], bucketMax = new int[gapNum];
        for (int i : nums) {
            numIndex = (int)Math.floor((double)(i - min) / gapSize);
            if (bucketMin[numIndex] == 0) {
                bucketMin[numIndex] = i;
            } else {
                bucketMin[numIndex] = Math.min(bucketMin[numIndex], i);
            }
            bucketMax[numIndex] = Math.max(bucketMax[numIndex], i);
        }
        int maxGap = 0, previous = 0;
        for (int i = 1; i < gapNum; ++i) {
            if (bucketMin[i] == 0) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - bucketMax[previous]);
            previous = i;
        }
        return maxGap;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumGap(new int[]{1,2}));
    }
}
