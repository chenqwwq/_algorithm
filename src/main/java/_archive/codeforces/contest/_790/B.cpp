//
// Created by 陈炳鑫 on 2022/5/10.
//


#include <iostream>

using namespace std;

const int INF = 0x3f3f3f3f;

int main() {
    int n;
    cin >> n;
    int cnt = 0, mmin = INF, num;
    long long toatl;
    while (n--) {
        mmin = INF;
        toatl = 0;
        cin >> cnt;
        for (int i = 0; i < cnt; ++i) {
            cin >> num;
            toatl += num;
            mmin = min(mmin, num);
        }
        printf("%lld\n", toatl - mmin * cnt);
    }
    return 0;
}