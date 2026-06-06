//
// Created by 陈炳鑫 on 2022/5/12.
//


#include <iostream>

using namespace std;

int m1[26], pos[26];
int ps[200000];
string t, p;

bool ok(int i) {
    for (int &po: pos) po = 0;
    int k = 0;
    for (char c: p) {
        if (m1[pos[c - 'a']] < k) {
            return false;
        }
        k = m1[pos[c - 'a']++];
    }
    return true;
}

int main() {
    cin >> t >> p;
    int n = t.length(), m = p.length();
    int l = 0, r = n - m;

    while (l < r) {
        int mid = (l + r) >> 1;
    }
    return 0;
}