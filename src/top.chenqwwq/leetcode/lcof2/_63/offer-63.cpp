//
// Created by chenqwwq on 2022/1/17.
//

#include "stdc++.h"
#include "common.h"

using namespace std;


class Solution {
private:
    struct TrieNode {
        char c;
        unordered_map<char, TrieNode *> childs;
        bool end;
        string word;


        TrieNode() : c(), childs(), end(), word() {}

        TrieNode(char c) : c(c), childs(), end(), word() {}
    } root;

    void insert(const string &world) {
        TrieNode *node = &root;
        for (auto i: world) {
            auto &cs = node->childs;
            if (cs.find(i) != cs.end()) {
                node = cs[i];
            } else {
                node = new TrieNode(i);
                cs[i] = node;
            }
        }
        if (node != nullptr) {
            node->end = true;
            node->word = world;
        }
    }

    string find(const string &world) {
        TrieNode *node = &root;
        for (auto i: world) {
            auto cs = node->childs;
            if (cs.find(i) == cs.end()) return world;
            node = cs[i];
            if (node->end) {
                return node->word;
            }
        }
        return world;
    }

public:
    string replaceWords(vector<string> &dictionary, string sentence) {
        for (auto word: dictionary) {
            insert(word);
        }
        stringstream ss;
        ss << sentence;
        string tmp, ans ;


        while (ss >> tmp) {
            ans += find(tmp) + " ";
        }
        return ans.substr(0,ans.length()-1);
    }
};

int main() {
    vector<string> p1{"a", "b", "c"};
    const Solution &solution = Solution();
    (new Solution)->replaceWords(p1, "the cattle was rattled by the battery");
}