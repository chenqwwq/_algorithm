//
// Created by 陈炳鑫 on 2022/4/28.
//


#include <iostream>
#include <vector>
#include <algorithm>
#include <functional>

using namespace std;

int main() {
    int N, M, S;
    cin >> N >> M >> S;
    int nums[N];
    for (int i = 0; i < N; ++i) cin >> nums[i];

    vector<vector<int>> tree(N, vector<int>{});
    int id, cnt, val;
    for (int i = 0; i < M; ++i) {
        cin >> id >> cnt;
        for (int j = 0; j < cnt; ++j) {
            cin >> val;
            tree[id].push_back(val);
        }
    }
    vector<vector<int>> ans;
    function<void(int id, int cur, vector<int> ns)> dfs;
    dfs = [&](int id, int cur, vector<int> ns) {
        if (cur > S) return;
        if (cur == S) {
            if (tree[id].empty()) ans.emplace_back(ns.begin(), ns.end());
            return;
        }
        for (auto next: tree[id]) {
            ns.push_back(nums[next]);
            dfs(next, cur + nums[next], ns);
            ns.pop_back();
        }
    };
    dfs(0, nums[0], {nums[0]});
    sort(ans.begin(), ans.end(), [&](vector<int> v1, vector<int> v2) -> bool {
        for (int i = 0; i < min(v1.size(), v2.size()); ++i) {
            if (v1[i] > v2[i]) return true;
            else if (v1[i] < v2[i]) return false;   // 傻逼的排序规则 老子真的是服了
        }
        return false;
    });
    for (auto a: ans) {
        printf("%d", a[0]);
        for (int i = 1; i < a.size(); ++i) printf(" %d", a[i]);
        cout << endl;
    }
    return 0;
}