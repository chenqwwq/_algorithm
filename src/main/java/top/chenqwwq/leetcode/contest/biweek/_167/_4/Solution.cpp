//
// Created by chenqwwq on 2025/10/12.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maxPartitionFactor(vector<vector<int> > &points) {
        int n = points.size();
        if (n < 2) return 0;

        // 最大的曼哈顿距离
        int max_dist = -1;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                max_dist = max(max_dist, abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]));
            }
        }


        // 判断是否是否合理
        // lowest 表示最小的曼哈顿距离
        auto check = [&](int lowest) -> bool {
            int cs[n]; // -1,1 表示两个图,0 表示未初始化
            memset(cs, 0, sizeof(cs));

            // 循环染色
            auto dfs = [&](auto &&dfs, int u, int color) -> bool {
                cs[u] = color;
                auto &p = points[u];
                for (int i = 0; i < n; i++) {
                    // 点位合法
                    if (i == u || (abs(p[0] - points[i][0]) + abs(p[1] - points[i][1])) >= lowest) {
                        continue;;
                    }

                    // 点位不合法
                    if (cs[i] == color || (cs[i] == 0 && !dfs(dfs, i, -color))) {
                        return false;
                    }
                }
                return true;
            };

            for (int i = 0; i < n; i++) {
                if (cs[i] != 0) continue;
                if (!dfs(dfs, i, 1)) return false;
            }
            return true;
        };

        int l = 0, r = max_dist + 1;
        while (l < r) {
            if (const int mid = (l + r) >> 1; check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
};
