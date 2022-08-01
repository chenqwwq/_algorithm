//
// Created by chenqwwq on 2022/7/12.
//


#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        bool ok = s.length() == 3 && (s[0] == 'Y' || s[0] == 'y') && (s[1] == 'e' || s[1] == 'E') &&
                  (s[2] == 'S' || s[2] == 's');
        cout << (ok ? "YES" : "NO") << endl;
    }
    return 0;
}