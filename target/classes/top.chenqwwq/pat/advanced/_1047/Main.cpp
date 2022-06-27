//
// Created by 陈炳鑫 on 2022/4/25.
//


#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N, K;
    cin >> N >> K;
    vector<vector<string>> ans(K, vector<string>());
    for (int i = 0; i < N; ++i) {
        string name;
        int C;
        cin >> name >> C;
        int idx;
        for (int j = 0; j < C; ++j) {
            cin >> idx;
            ans[idx - 1].push_back(name);
        }
    }
    for (int i = 0; i < K; ++i) {
        auto ns = ans[i];
        printf("%d %d\n", i + 1, (int) ns.size());
        sort(ns.begin(), ns.end());
        for (const auto &name: ns) printf("%s\n", name.c_str());
    }
    return 0;
}