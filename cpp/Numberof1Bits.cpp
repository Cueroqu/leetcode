//
// Created by Zhun Qu on 6/16/17.
//

#include <cstdint>>
#include <iostream>
using namespace std;

class Solution {
public:
    int hammingWeight(uint32_t n) {
        int cnt = 0;
        for (; n > 0; n >>= 1) {
            cnt += (n%2);
        }
        return cnt;
    }
};

int main() {
    Solution *s = new Solution();
    cout << s->hammingWeight(11) << endl;
    delete s;
}