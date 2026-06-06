//
// Created by 陈炳鑫 on 2022/4/22.
//


#include <iostream>
#include <map>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);
    int m, num, ans;
    for (int i = 0; i < n; ++i) {
        map<int, int> mmap;
        scanf("%d", &m);
        ans = -1;
        for (int j = 0; j < m; ++j) {
            scanf("%d", &num);
            if (++mmap[num] == 3) ans = num;
        }
        printf("%d\n", ans);
    }
    return 0;
}