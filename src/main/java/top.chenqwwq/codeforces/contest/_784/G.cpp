//
// Created by 陈炳鑫 on 2022/4/23.
//



#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    while (n--) {
        int a, b;
        cin >> a >> b;
        string ss[a];
        for (int i = 0; i < a; ++i) cin >> ss[i];
        for (int j = 0; j < b; ++j) {
            int bt = a - 1;
            for (int i = a - 1; i >= 0; --i) {
                if (ss[i][j] == 'o') {
                    bt = i - 1;
                } else if (ss[i][j] == '*') {
                    if (bt != i) swap(ss[bt][j], ss[i][j]);
                    bt--;
                }
            }
        }
        for (int i = 0; i < a; ++i)
            printf("%s\n", ss[i].c_str());
    }
    return 0;
}