//
// Created by chenqwwq on 2022/1/17.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {

private:
    vector<int> ufs;

    void init(int n) {
        ufs.resize(n + 1);
        for (int i = 1; i <= n; ++i) {
            ufs[i] = i;
        }
    }

    int getRoot(int i) {
        if (ufs[i] != i) {
            ufs[i] = getRoot(ufs[i]);
        }
        return ufs[i];
    }

    void conn(int i, int j) {
        ufs[getRoot(j)] = getRoot(i);
    }

    bool isConn(int i, int j) {
        if (i < 0 || j < 0 || i >= ufs.size() || j >= ufs.size()) {
            return false;
        }
        return getRoot(i) == getRoot(j);
    }

public:
    vector<int> findRedundantConnection(vector<vector<int>> &edges) {
        // 找到图中的环，并且返回最后一条路径
        auto n = edges.size();
        init(n);
        for (auto edge: edges) {
            if (!isConn(edge[0], edge[1])) conn(edge[0], edge[1]);
            else return {edge[0], edge[1]};
        }
        return {-1, -1};
    }
};


int main() {
    vector<vector<int>> p1{{1, 4},
                           {3, 4},
                           {1, 3},
                           {1, 2},
                           {4, 5}};
    const vector<int> &connection = (new Solution)->findRedundantConnection(p1);
    for (auto i : connection) {
        cout << i << endl;
    }
}