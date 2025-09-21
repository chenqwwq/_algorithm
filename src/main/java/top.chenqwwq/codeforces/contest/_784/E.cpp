//
// Created by 陈炳鑫 on 2022/4/22.
//


#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;
    while (n--) {
        int m;
        cin >> m;
        string ss[m];
        long long ans = 0;
        for (int i = 0; i < m; ++i) cin >> ss[i];
        vector<vector<int>> h1(11, vector<int>(11, 0)), h2(11, vector<int>(11, 0));
        vector<int> s1(11, 0), s2(11, 0);
        for (int i = m - 1; i >= 0; --i) {
            int a = ss[i][0] - 'a', b = ss[i][1] - 'a';
            ans += (s1[a] - h1[a][b]) + (s2[b] - h2[b][a]);
            h1[a][b]++;
            h2[b][a]++;
            s1[a]++;
            s2[b]++;
        }
        printf("%lld\n", ans);
    }
    return 0;
}