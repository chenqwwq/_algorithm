//
// Created by chenqwwq on 2022/11/22.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

int main() {
    int N = 2e5 + 10, INF = 0x3f3f3f3f;
    int t, n;
    int nums[N];
    cin >> t;
    while (t--) {
        cin >> n;
        int a = -INF, b = -INF; // 最大值 和 次最大值
        int cnt = 0;   // 最大值的个数
        for (int i = 0; i < n; i++) {
            cin >> nums[i];
            if (nums[i] > a) {
                b = a;
                a = nums[i];
                cnt = 1;
            } else if (nums[i] == a) cnt++;
            else if (cnt < 2 && nums[i] > b) b = nums[i];
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (i != 0) cout << " ";
            if (num == a) {
                if (cnt > 1) cout << 0;
                else cout << num - b;
            } else cout << num - a;
        }
        cout << endl;
    }
    return 0;
}