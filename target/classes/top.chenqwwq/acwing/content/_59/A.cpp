//
// Created by chenqwwq on 2022/7/9.
//


#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, num;
    int sum = 0, mp = 0;
    cin >> n;
    while (n--) {
        cin >> num;
        sum += num;
        mp = min(mp, sum);
    }
    cout << sum - mp << endl;
    return 0;
}