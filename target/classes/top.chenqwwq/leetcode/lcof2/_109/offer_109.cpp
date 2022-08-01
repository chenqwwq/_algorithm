//
// Created by chenqwwq on 2022/1/12.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
private:
    unordered_set<string> ds;
    string seed = "0000";
    int INF = 0x3F3F3F3F;
public:
    int openLock(vector<string> &deadends, string target) {
        if (target == "0000") {
            return 0;
        }
        if (deadends.empty()) {
            int ans = 0;
            for (char c: target) {
                ans += c - 'a';
            }
            return ans;
        }
        ds = unordered_set<string>(deadends.begin(), deadends.end());
        if (ds.count(target) || ds.count("0000")) {
            return -1;
        }

        auto prev = [](char c) -> char {
            return c == '0' ? '9' : (char) c - 1;
        };

        auto next = [](char c) -> char {
            return c == '9' ? '0' : (char) c + 1;
        };

        auto get = [&](string &curr) -> vector<string> {
            vector<string> tmp(8);
            for (int i = 0; i < 4; ++i) {
                char c = curr[i];
                curr[i] = prev(c);
                tmp.push_back(curr);
                curr[i] = next(c);
                tmp.push_back(curr);
                curr[i] = c;
            }
            return tmp;
        };

        queue<pair<string, int>> q;
        unordered_set<string> vis;
        q.push({seed, 0});
        vis.insert(seed);
        while (!q.empty()) {
            auto[curr, cost] = q.front();
            q.pop();
            for (auto &status: get(curr)) {
                if (ds.count(status) || vis.count(status)) {
                    continue;
                }
                if (status == target) {
                    return cost + 1;
                }
                vis.insert(status);
                q.push({status, cost + 1});
            }
        }
        return -1;
    }
};