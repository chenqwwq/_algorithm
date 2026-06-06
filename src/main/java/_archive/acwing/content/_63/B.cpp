//
// Created by chenqwwq on 2022/8/8.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    string s;
    cin >> s;
    if (s.length() < 2) {
        cout << "No" << endl;
        return 0;
    }
    stack<char> st;
    int cnt = 0;
    for (char & i : s) {
        if (st.empty() || st.top() != i) st.push(i);
        else {
            cnt++;
            st.pop();
        }
    }
    cout << (cnt & 1 ? "Yes" : "No") << endl;
    return 0;
}