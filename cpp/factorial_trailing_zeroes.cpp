#include <cstdio>

class Solution {
public:
    int trailingZeroes(int n) {
        int num_5 = 0;
        double n_backup = n;
        for (int i = 1;; ++i) {
            n_backup /= 5.0;
            if (n_backup < 1) break;
            num_5 += int(n_backup);
        }
        return num_5;
    }
};

int main() {
    Solution* s = new Solution();
    printf("%d\n", s->trailingZeroes(23));
    printf("%d\n", s->trailingZeroes(100));
    return 0;
}