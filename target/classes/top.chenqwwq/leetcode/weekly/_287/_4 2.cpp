//
// Created by 陈炳鑫 on 2022/4/3.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Trie {

public:
    unordered_map<char, Trie *> children;
    bool isEnd;

    Trie() : children(), isEnd(false) {}

    void insert(string word) {
        Trie *node = this;
        for (char ch: word) {
            if (node->children.find(ch) == node->children.end()) {
                node->children[ch] = new Trie();
            }
            node = node->children[ch];
        }
        node->isEnd = true;
    }
};

class Encrypter {
public:
    unordered_map<char, string> h1;
    Trie *trie;

    Encrypter(vector<char> &keys, vector<string> &values, vector<string> &dictionary) {
        for (int i = 0; i < keys.size(); ++i) {
            h1[keys[i]] = values[i];
        }
        trie = new Trie();
        for (auto d: dictionary) trie->insert(d);
    }

    string encrypt(string word1) {
        string ans;
        for (char c: word1) ans += h1[c];
        return ans;
    }

    int decrypt(string w) {
        return decrypt(w, trie, 0);
    }

    int decrypt(string w, Trie *trie, int i) {
        if (i >= w.size()) return trie->isEnd;
        string target = w.substr(i, 2);
        int ans = 0;
        for (auto[k, v]: trie->children) {
            if (h1[k] == target) ans += decrypt(w, v, i + 2);
        }
        return ans;
    }
};

int main() {
    vector<char> v1{'a', 'b', 'c', 'd'};
    vector<string> v2{"ei", "zf", "ei", "am"};
    vector<string> v3{"abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"};
    Encrypter *p = new Encrypter(v1, v2, v3);
    cout << p->encrypt("abcd") << endl;
    cout << p->decrypt("eizfeiam") << endl;

}