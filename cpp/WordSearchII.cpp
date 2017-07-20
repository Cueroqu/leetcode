//
// Created by Zhun Qu on 6/16/17.
//

#include <string>
#include <vector>
#include <unordered_set>
using namespace std;

class TrieNode {
public:
    TrieNode *next[26];
    string word;
    TrieNode() {
        for (int i = 0; i < 26; ++i) {
            next[i] = NULL;
        }
    }
    ~TrieNode() {
        for (int i = 0; i < 26; ++i) {
            if (next[i] != NULL) {
                delete next[i];
            }
        }
    }
};

class Solution {
    TrieNode* buildTrie(vector<string> words) {
        TrieNode* root = new TrieNode(), *current;
        int idx;
        for (string s : words) {
            current = root;
            for (char c : s) {
                idx = c - 'a';
                if (current->next[idx] == NULL) {
                    current->next[idx] = new TrieNode();
                }
                current = current->next[idx];
            }
            current->word = s;
        }
        return root;
    }
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        vector<string> ans;
        unordered_set<string> wordSet;
        if (board.size() == 0) {
            return ans;
        }
        TrieNode *root = buildTrie(words);
        int i, j, m = board.size(), n = board[0].size();
        for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                addWords(board, i, j, root, ans, wordSet);
            }
        }
        delete root;
        sort(ans.begin(), ans.end());
        return ans;
    }

    void addWords(vector<vector<char>>& board, int row, int col, TrieNode *currentNode, vector<string>& ans, unordered_set<string>& wordSet) {
        char c = board[row][col];
        int idx = c - 'a';
        if (c == '#' || currentNode->next[idx] == NULL) {
            return;
        }
        currentNode = currentNode->next[idx];
        if (!currentNode->word.empty() && wordSet.find(currentNode->word) == wordSet.end()) {
            ans.push_back(currentNode->word);
            wordSet.insert(currentNode->word);
        }

        board[row][col] = '#';
        if (row > 0) {
            addWords(board, row-1, col, currentNode, ans, wordSet);
        }
        if (row < board.size() - 1) {
            addWords(board, row+1, col, currentNode, ans, wordSet);
        }
        if (col > 0) {
            addWords(board, row, col-1, currentNode, ans, wordSet);
        }
        if (col < board[0].size() - 1) {
            addWords(board, row, col+1, currentNode, ans, wordSet);
        }
        board[row][col] = c;
    }
};

int main() {
    vector<vector<char>> boards;
    string ls[] = {"oaan", "etae","ihkr","iflv"};
    for (int i = 0; i < 4; ++i) {
        boards.push_back(vector<char>(ls[i].begin(), ls[i].end()));
    }
    string wordArr[] = {"oath","pea","eat","rain"};
    Solution *s = new Solution();
    vector<string> words(wordArr, wordArr+(sizeof(wordArr) / sizeof(string)));
    for (auto str : s->findWords(boards, words)) {
        printf("%s\n", str.c_str());
    }
    delete s;
    return 0;
}