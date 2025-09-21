//
// Created by chenqwwq on 2022/6/14.
//



#include "iostream"
#include "map"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n, m;
    cin >> t;
    map<int, int> mmap;
    while (t--) {
        mmap.clear();
        cin >> n;
        while (n--) {
            cin >> m;
            mmap[m]++;
        }

        int a = 0, b = 0;
        for (auto [k, v]: mmap) {
            a++;
            b += v - 1;
        }
        cout << a - (b & 1) << endl;

    }
    return 0;
}