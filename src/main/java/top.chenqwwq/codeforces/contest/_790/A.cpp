//
// Created by 陈炳鑫 on 2022/5/10.
//


#include <iostream>

using namespace std;

int getInt(char c) {
    return c - '0';
}

int main() {
    int n;
    cin >> n;
    string dig;
    while (n--) {
        cin >> dig;
        printf("%s\n", getInt(dig[0]) + getInt(dig[1]) + getInt(dig[2]) == getInt(dig[3]) + getInt(dig[4]) + getInt(dig[5]) ? "YES" : "NO");
    }
    return 0;
}