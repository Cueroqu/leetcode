//
// Created by Zhun Qu on 6/8/17.
//

#include <vector>
#include <string>
#include <algorithm>
using namespace std;

class Solution {
public:
    string largestNumber(vector<int> &num) {
        vector<string> numStr;
        for (auto i : num) {
            numStr.push_back(to_string(i));
        }
        sort(numStr.begin(), numStr.end(), [](string &s1, string &s2){
            return s1+s2>s2+s1;
        });
        string ans;
        for (auto s : numStr) {
            ans += s;
        }
        if (ans[0] == '0') {
            return "0";
        }
        return ans;
    }
};

int main() {
    string a = "abc";

}

