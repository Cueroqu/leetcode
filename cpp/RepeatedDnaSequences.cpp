//
// Created by Zhun Qu on 6/9/17.
//

#include <string>
#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        string clip = s.substr(0, 10);
        vector<string> result;
        unordered_set<string> stores;
        stores.insert(clip);
        unordered_set<string> added;
        for (int i = 10; i < s.length(); ++i) {
            clip = clip.substr(1) + s[i];
            if (stores.count(clip) > 0 && added.count(clip) == 0){
                result.push_back(clip);
                added.insert(clip);
            }
            stores.insert(clip);
        }
        return result;
    }
};

int main() {
    Solution *s = new Solution();
    for (auto clip : s->findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")) {
        printf("%s\n", clip.c_str());
    }
    delete s;
}

