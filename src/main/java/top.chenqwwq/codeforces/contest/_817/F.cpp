//
// Created by chenqwwq on 2022/9/13.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

int main() {
    int maxn = 50;
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n, m;
    string ss[maxn];
    vector<vector<int>> pp(3, vector<int>(2, 0));
    function check = [&]() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bool ok = true;
                // 当前位置为星号
                if (ss[i][j] == '*') {
                    // 遍历周边9个区域获取星号坐标
                    int cnt = 0;
                    for (int a = max(i - 1, 0); a <= min(i + 1, n - 1); a++) {
                        for (int b = max(j - 1, 0);b <= min(j + 1, m - 1); b++) {
                            if (ss[a][b] == '*') {
                                if (cnt < 3) {
                                    pp[cnt][0] = a;
                                    pp[cnt++][1] = b;
                                }
                            }
                        }
                    }
                    // 不等于三个星号就是直接异常
                    if (cnt != 3) ok = false;
                    else {
                        // 判断三个点
                        // x,y x,y+1 y x+1,y+1
                        // x,y x+1,y x+1,y+1
                        sort(pp.begin(), pp.end(), [&](auto p1, auto p2) {
                            return (p1[0] + p1[1]) < (p2[0] + p2[1]) ||
                                   (p1[0] + p1[1]) == (p2[0] + p2[1] && p1[0] < p2[0]);
                        });
                        auto p0 = pp[0], p1 = pp[1], p2 = pp[2];
                        ok = false;
                        if (p0[0] == p1[0] - 1 && p0[1] == p1[1] && p1[0] == p2[0] && p1[1] == p2[1] - 1) ok = true;
                        if (p0[0] == p1[0] && p0[1] == p1[1] - 1 && p1[0] == p2[0] - 1 && p1[1] == p2[1]) ok = true;
                        if (p0[0] == p1[0] - 1 && p0[1] == p1[1] + 1 && p2[0] == p1[0] && p2[1] == p0[1]) ok = true;
                        if (p1[0] == p2[0] - 1 && p1[1] == p2[1] + 1 && p0[0] == p1[0] && p0[1] == p2[1]) ok = true;
                        ss[p0[0]][p0[1]] = '+';
                        ss[p1[0]][p1[1]] = '+';
                        ss[p2[0]][p2[1]] = '+';
                    }
                } else if (ss[i][j] == '.') {
                    continue;
                } else if (ss[i][j] == '+') {
                    for (int a = max(i - 1, 0); a <= min(i + 1, n - 1); a++) {
                        for (int b = max(j - 1, 0); b <= min(j + 1, m - 1); b++) {
                            if (ss[a][b] == '*') ok = false;
                        }
                    }
                }
                if (!ok) {
                    cout << "NO" << endl;
                    return;
                }
            }
        }
        cout << "YES" << endl;
    };
    cin >> t;
    while (t--) {
        cin >> n >> m;
        for (int i = 0; i < n; i++) cin >> ss[i];
        check();
    }
    return 0;
}