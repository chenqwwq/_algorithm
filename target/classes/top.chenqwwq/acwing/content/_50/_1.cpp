//
// Created by 陈炳鑫 on 2022/5/7.
//


#include <iostream>
#include <cstring>

using namespace std;

int main() {
    int n;
    cin >> n;
    bool exi[n + 1];
    memset(exi, 0, sizeof(exi));
    int num;
    for (int i = 0; i < n; ++i) {
        cin >> num;
        exi[num] = true;
    }
    for (int i = 1; i <= n; ++i) {
        if (!exi[i]) {
            cout << i << endl;
            return 0;
        }
    }
    return 0;
}