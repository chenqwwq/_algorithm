//
// Created by chenqwwq on 2022/7/12.
//

#include "iostream"

using namespace std;

int main() {
    const int N = 101;
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n;
    int nums[N][N];
    string str;
    cin >> t;
    while (t--) {
        cin >> n;
        for (int i = 0; i < n; i++) {
            cin >> str;
            for (int j = 0; j < n; j++) {
                nums[i][j] = str[j] - '0';
            }
        }

        int ans = 0;
        for (int i = 0; i < (n + 1) >> 1; i++) {
            for (int j = i; j < n - i -1; j++) {
                int k = nums[i][j] + nums[j][n - i - 1] + nums[n - i - 1][n - 1 - j] + nums[n - 1 - j][i];
                ans += min(k, 4 - k);
            }
        }
        cout << ans << endl;
    }
    return 0;
}