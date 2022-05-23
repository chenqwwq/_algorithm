//
// Created by 陈炳鑫 on 2022/5/10.
//


#include <iostream>

using namespace std;


int diff(string &a, string &b) {
    int n = (int) a.length();
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        int tmp = abs(a[i] - b[i]);
        ans += max(a[i],b[i]) - min(a[i],b[i]);
    }
    return ans;
}

const int INF = 0x3f3f3f3f;


int main() {
    int n, a, b, mmin;
    string ss[51];
    cin >> n;
    while (n--) {
        mmin = INF;
        cin >> a >> b;
        for (int i = 0; i < a; ++i) cin >> ss[i];
        for (int i = 0; i < a; ++i) {
            for (int j = i + 1; j < a; ++j) {
                mmin = min(diff(ss[i], ss[j]), mmin);
            }
        }
        printf("%d\n", mmin);
    }
    return 0;
}