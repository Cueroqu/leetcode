//
// Created by Zhun Qu on 6/16/17.
//

#include <cstdint>
#include <cstring>
#include <cstdio>

class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        short *binary = new short[32];
        memset(binary, 0, sizeof(short) * 32);
        for (int i = 0; i < 32, n > 0; ++i, n /= 2) {
            binary[i] = n%2;
        }
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            result = (result << 1) + binary[i];
        }
        return result;
    }
};

int main() {
    Solution* s = new Solution();
    printf("%d\n", s->reverseBits(43261596));
    delete s;
}