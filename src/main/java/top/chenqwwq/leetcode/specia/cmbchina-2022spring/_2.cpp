//
// Created by 陈炳鑫 on 2022/4/10.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> lightSticks(int height, int width, vector<int> &indices) {
        int total = (height + 1) * (width + 1);
        unordered_map<int, vector<int>> mmap;
        unordered_set<int> sset(indices.begin(), indices.end());

        int pos = width * 2 + 1;
        for (int i = 0; i <= height; ++i) {
            int s1 = i * pos, s2 = width + i * pos;
            for (int j = 0; j <= width; ++j) {
                int l = j + width * i;
                if (mmap.find(l) == mmap.end()) mmap[l] = {};
                if (j != width && sset.find(s1 + j) != sset.end()) mmap[l].push_back(l + 1);
                if (i != height && sset.find(s2 + j) != sset.end()) mmap[l].push_back(l + width + 1);
            }
        }
        int mmin = INT_MAX;
        vector<int> ans;
        for (int i = 0; i < total; ++i) {
            if (mmap[i].empty()) continue;
            int level = 0;
            vector<bool> vis(total, false);
            vis[i] = true;
            vector<int> stack(mmap[i].begin(),mmap[i].end());
            while (!stack.empty()){

            }
        }
    }
};