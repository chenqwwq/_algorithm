//
// Created by chenqwwq on 2024/7/15.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;


class UnionFind {
public:
    vector<int> parent;

    UnionFind(int n) {
        parent.resize(n);
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    void unionS(int i, int j) {
        parent[find(i)] = find(j);
    }
};

class Solution {
public:

    vector<vector<string>> accountsMerge(vector<vector<string>> &accounts) {
        int n = accounts.size();
        unordered_map<string, int> email2Idx;
        vector<string> names(n);
        for (auto &account: accounts) {
            string &name = account[0];
            for (int i = 1; i < account.size(); i++) {
            }
        }
        return {};
    }
};

int main() {
    vector<vector<string>> ss = {{"David", "David0@m.co", "David1@m.co"},
                                 {"David", "David3@m.co", "David4@m.co"},
                                 {"David", "David4@m.co", "David5@m.co"},
                                 {"David", "David2@m.co", "David3@m.co"},
                                 {"David", "David1@m.co", "David2@m.co"}};

    (new Solution)->accountsMerge(ss);
}