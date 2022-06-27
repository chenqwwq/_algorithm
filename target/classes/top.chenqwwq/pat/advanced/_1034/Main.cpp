//
// Created by 陈炳鑫 on 2022/4/17.
// 8 59
//AAA BBB 10
//BBB AAA 20
//AAA CCC 40
//DDD EEE 5
//EEE DDD 70
//FFF GGG 30
//GGG HHH 20
//HHH FFF 10
//


#include "iostream"
#include <algorithm>
#include "unordered_map"
#include "unordered_set"
#include "deque"
#include "vector"

using namespace std;

int main() {
    int n, k;
    scanf("%d %d", &n, &k);
    unordered_map<string, unordered_map<string, int>> hash;
    unordered_map<string, int> weight;
    string s1, s2;
    int t;
    for (int i = 0; i < n; ++i) {
        cin >> s1 >> s2 >> t;
        if (hash.find(s1) == hash.end()) hash[s1] = {};
        if (hash.find(s2) == hash.end()) hash[s2] = {};
        hash[s1][s2] += t;
        hash[s2][s1] += t;
        weight[s1] += t;
        weight[s2] += t;
    }

    unordered_set < string > vis;
    vector<pair<string, int>> ans;
    deque<string> dq;
    for (auto [k1, v]: hash) {
        if (vis.count(k1)) continue;
        vis.insert(k1);
        dq.push_back(k1);
        string leader;
        int size = 0, max_weight = 0, total_weight = 0;
        while (!dq.empty()) {
            size++;
            auto cur = dq.front();
            dq.pop_front();
            total_weight += weight[cur];
            if (weight[cur] > max_weight) {
                max_weight = weight[cur];
                leader = cur;
            }
            for (auto [key, val]: hash[cur]) {
                if (vis.count(key)) continue;
                vis.insert(key);
                dq.push_back(key);
            }
        }
        if (size > 2 && total_weight >> 1 > k)ans.emplace_back(leader.c_str(), size);
    }
    printf("%d\n", (int) ans.size());
    sort(ans.begin(), ans.end());
    for (auto vv: ans)printf("%s %d\n", vv.first.c_str(), vv.second);
    return 0;
}