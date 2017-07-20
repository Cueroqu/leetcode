//
// Created by Zhun Qu on 6/14/17.
//
#include <string>
#include <cmath>
#include <unordered_map>
using namespace std;

class Solution {
private:
    int i = 0;
    const int BASE = 10 + 26 + 26;
    const int MAX_NUM = pow(BASE, 6.0);
    unordered_map<string, string> short_to_long;
    unordered_map<string, string> long_to_short;

    string get_next_short() {
        string ans = "";
        int copy = i++, cur;
        while (copy > 0) {
            cur = copy % BASE;
            if (cur < 10) {
                ans = to_string(cur) + ans;
            } else if (cur < 36) {
                ans = char((cur - 10) + 'A') + ans;
            } else {
                ans = char((cur - 36) + 'a') + ans;
            }
            copy /= BASE;
        }
        while (ans.size() < 6) {
            ans = "0" + ans;
        }
        return "http://tinyurl.com/" + ans;
    }

public:

    // Encodes a URL to a shortened URL.
    string encode(string longUrl) {
        unordered_map<string, string>::const_iterator it = long_to_short.find(longUrl);
        string shortUrl;
        if (it == long_to_short.end()) {
            shortUrl = get_next_short();
            short_to_long[shortUrl] = longUrl;
            long_to_short[longUrl] = shortUrl;
        } else {
            shortUrl = long_to_short[longUrl];
        }
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    string decode(string shortUrl) {
        return short_to_long[shortUrl];
    }
};

// Your Solution object will be instantiated and called as such:
// Solution solution;
// solution.decode(solution.encode(url));

int main() {
    string s1 = "https://leetcode.com/problems/design-tinyurl", s1_short;
    string s2 = "https://leetcode.com/problems/design-tinyurl2", s2_short;
    Solution *s = new Solution;
    s1_short = s->encode(s1);
    printf("%s\n", s1_short.c_str());
    printf("%s\n", (s2_short = s->encode(s2)).c_str());
    printf("%d\n", s1 == s->decode(s1_short));
    printf("%d\n", s2 == s->decode(s2_short));
    return 0;
}
