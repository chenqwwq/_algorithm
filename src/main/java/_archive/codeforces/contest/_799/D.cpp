//
// Created by chenqwwq on 2022/6/14.
//


#include "iostream"

using namespace std;

bool is(int ck) {
    int h = ck / 60, m = ck % 60;
    return h == (m % 10) * 10 + (m / 10);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    string s;
    while (t--) {
        cin >> s;
        int h = (s[0] - '0') * 10 + (s[1] - '0'), m = (s[3] - '0') * 10 + (s[4] - '0');
        int k = h * 60 + m, kk = k;

        int len;
        cin >> len;
        int ans = is(kk);
        while ((kk = (kk + len) % 1440) != k){
            if (is(kk)) ans++;
        }
        cout << ans << endl;
    }
    return 0;
}
