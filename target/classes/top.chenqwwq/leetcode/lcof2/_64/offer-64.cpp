//
// Created by chenqwwq on 2022/1/19.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class MagicDictionary {
sprivate:
    vector<MagicDictionary *> next;
    bool end;

    void _insert(string word) {
        MagicDictionary *node = this;
        for (auto &ch: word) {
            int pos = ch - 'a';
            if (!node->next[pos]) node->next[pos] = new MagicDictionary;
            node = node->next[pos];
        }
        node->end = true;
    }

    bool _search(string word) {
        MagicDictionary *node = this;
        for (auto &ch: word) {
            int pos = ch - 'a';
            if (!node->next[pos]) return false;
            node = node->next[pos];
        }
        return node->end;
    }

public:
    /** Initialize your data structure here. */
    MagicDictionary() {
        next = vector<MagicDictionary *>(26);
        end = false;
    }

    void buildDict(vector<string> dictionary) {
        for (auto &word: dictionary) _insert(word);
    }

    bool search(string searchWord) {
        auto n = searchWord.length();
        MagicDictionary *node = this;
        for (int i = 0; i < n; i++) {
            int pos = searchWord[i] - 'a';
            for (int j = 0;j < 26;j++){
                if(j == pos){
                    continue;
                }
                auto child = node->next[j];
                if (child && child->_search(searchWord.substr(i + 1))) {
                    return true;
                }
            }
            if (!node->next[pos]) return false;
            node = node->next[pos];
        }
        return false;
    }
};

int main() {
    MagicDictionary *pDictionary = new MagicDictionary;
    vector<string> p1{"hello", "leetcode"};
    pDictionary->buildDict(p1);
    cout << pDictionary->search("hello");
}
