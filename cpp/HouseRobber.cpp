//
// Created by Zhun Qu on 6/18/17.
//
#include <vector>
using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        if (nums.size() == 1) return nums[0];
        if (nums.size() == 2) return max(nums[0], nums[1]);
        if (nums.size() == 3) return max(nums[0]+nums[2], nums[1]);
        int total[nums.size()], ans;
        total[0] = nums[0];
        total[1] = nums[1];
        total[2] = nums[0] + nums[2];
        for (int i = 3; i < nums.size(); ++i) {
            total[i] = max(total[i-2], total[i-3]) + nums[i];
        }
        return max(total[nums.size()-1], total[nums.size()-2]);
    }
};

int main() {
    int myints[] = {1, 1, 2, 1};
    vector<int> nums(myints, myints + sizeof(myints) / sizeof(int));
    Solution s;
    printf("%d\n", s.rob(nums));
}
