//
// Created by chenqwwq on 2022/1/18.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;
class Trie {
private:
    struct node {
        char c;
        vector<node *> child;
        bool end;
        // optional
        string word;

        node(char c) : c(c) {
            child = vector<node *>(26);
            end = false;
        }
    };

    node* root = new node(' ');
public:

    /** Initialize your data structure here. */
    Trie() {
    }

    /** Inserts a word into the trie. */
    void insert(const string &word) {
        node *tmp = root;
        for (auto c: word) {
            int pos = c - 'a';
            if (tmp->child[pos] != nullptr) tmp = tmp->child[pos];
            else {
                tmp->child[pos] = new node(c);
                tmp = tmp->child[pos];
            }
        }
        tmp->end = true;
    }

    /** Returns if the word is in the trie. */
    bool search(const string &word) {
        node *tmp = root;
        for (char c: word) {
            int pos = c - 'a';
            if (tmp->child[pos] != nullptr) tmp = tmp->child[pos];
            else return false;
        }
        return tmp->end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(const string &prefix) {
        node *tmp = root;
        for (char c: prefix) {
            int pos = c - 'a';
            if (tmp->child[pos] != nullptr) tmp = tmp->child[pos];
            else return false;
        }
        return true;
    }
};
