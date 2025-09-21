//
// Created by 陈炳鑫 on 2022/4/5.
//


#include "bits/stdc++.h";

using namespace std;

char c[14] = {"0123456789ABC"};

string get(int num) {
    string ans;
    return ans + c[num / 13] + c[num % 13];
}

int main() {
    int r, g, b;
    scanf("%d %d %d", &r, &g, &b);
    cout << "#" << get(r) << get(g) << get(b) << endl;
    return 0;
}
