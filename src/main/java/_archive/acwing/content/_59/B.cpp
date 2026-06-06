//
// Created by chenqwwq on 2022/7/9.
//

#include "iostream"
#include "vector"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long num;
    cin >> num;
    if ((num & 1) == 0) {
        cout << (num >> 1) << endl;
        return 0;
    }
    for (long i = 2; i * i <= num; i++) {
        if (!(num % i)) {
            cout << ((num - i) >> 1) + 1 << endl;
            return 0;
        }
    }
    cout << 1 << endl;
    return 0;
}