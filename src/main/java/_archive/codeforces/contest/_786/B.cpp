//
// Created by 陈炳鑫 on 2022/5/12.
//


#include <iostream>

using namespace std;

int main() {
    int t;
    string s;
    cin >> t;
    while (t--) {
        cin >> s;
        printf("%d\n", 25 * (s[0] - 'a') + s[1] - 'a' + (s[1] > s[0] ? 0 : 1));
    }
    return 0;
}