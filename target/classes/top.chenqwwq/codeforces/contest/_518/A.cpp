//
// Created by 沽酒 on 2022/6/30.
//

#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    string s1, s2;
    cin >> s1;
    cin >> s2;
    int n = (int) s1.length();
    bool ok = false;
    string ans;
    for (int i = n - 1; i >= 0; --i) {
        // s1 的字典序小于 s2
        if (!ok) {
            if (s1[i] + 1 <= 'z') {
                ans = (char) (s1[i] + 1) + ans;
                ok = true;
            }else ans = 'a' + ans;
        } else ans = s1[i] + ans;
    }
    cout << (ans == s2 ? "No such string" : ans) << endl;
    return 0;
}