//
// Created by chenqwwq on 2022/6/14.
//


#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        int a, b, c, d;
        cin >> a >> b >> c >> d;
        int cnt = 0;
        if (a < b) cnt++;
        if (a < c) cnt++;
        if (a < d) cnt++;
        cout << cnt << endl;
    }
    return 0;
}