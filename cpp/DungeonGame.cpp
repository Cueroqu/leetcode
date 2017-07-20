#include <vector>
using namespace std;

class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        int M = dungeon.size(), N = dungeon[0].size(), i, j;
        vector<vector<int> > hp(M+1, vector<int>(N+1, INT_MAX));
        hp[M][N-1] = hp[M-1][N] = 1;
        for (i = M-1; i >= 0; --i) {
            for (j = N-1; j >= 0; --j) {
                hp[i][j] = min(hp[i+1][j], hp[i][j+1]) - dungeon[i][j];
                if (hp[i][j] <= 0) hp[i][j] = 1;
            }
        }
        return hp[0][0];
    }
};

int main(int argc, char** argv) {
    vector<vector<int>> dungeon;
    // test case 1
    if (strcmp(argv[1], "1") == 0) {
        dungeon.push_back(vector<int>());
        dungeon[0].push_back(-2);
        dungeon[0].push_back(-3);
        dungeon[0].push_back(3);
        dungeon.push_back(vector<int>());
        dungeon[1].push_back(-5);
        dungeon[1].push_back(-10);
        dungeon[1].push_back(1);
        dungeon.push_back(vector<int>());
        dungeon[2].push_back(10);
        dungeon[2].push_back(30);
        dungeon[2].push_back(-5);
    }
    else if (strcmp(argv[1], "2") == 0) {
        // test case 2
        dungeon.push_back(vector<int>());
        dungeon[0].push_back(0);
        dungeon[0].push_back(0);
    }
    Solution *s = new Solution();
    printf("%d\n", s->calculateMinimumHP(dungeon));
	return 0;
}
