//
// Created by 陈炳鑫 on 2022/3/13.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int digArtifacts(int n, vector<vector<int>> &artifacts, vector<vector<int>> &dig) {
        int m = artifacts.size();
        vector<int> as(m, 0);
        unordered_map<int, int> hash;
        for (int i = 0; i < m; ++i) {
            auto arti = artifacts[i];
            int q = arti[0], p = arti[1], x = arti[2], y = arti[3];
            as[i]++;
            hash[getMask(q, p, n)] = i;
            for (int k = q + 1; k <= x; ++k) {
                as[i]++;
                hash[getMask(k, p, n)] = i;
            }
            for (int k = p + 1; k <= y; ++k) {
                as[i]++;
                hash[getMask(q, k, n)] = i;
            }
            if (q != x && y != p) {
                as[i]++;
                hash[getMask(x, y, n)] = i;
            }
        }

        for (auto d: dig) {
            int mask = getMask(d[0], d[1], n);
            if (hash.find(mask) != hash.end()) as[hash[mask]]--;

        }

        int ans = 0;
        for (int num: as) ans += (num == 0 ? 1 : 0);
        return ans;
    }

    int getMask(int x, int y, int n) {
        return x * n + y;
    }
};