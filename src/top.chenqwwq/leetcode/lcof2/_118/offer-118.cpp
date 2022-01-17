//
// Created by 陈炳鑫 on 2022/1/17.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {

private:
    vector<int> ufs;

    int getRoot(int i) {
        if (ufs[i] != i) {
            return ufs[i] = getRoot(ufs[i]);
        }
        return i;
    }

    void conn(int i, int j) {
        ufs[i] = j;
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
        ufs.resize(n);
        for (auto edge: edges) {
            if (isConn(edge[0], edge[1])) {
                
            }
        }
    }


};