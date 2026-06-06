//
// Created by 陈炳鑫 on 2022/4/28.
//

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;
    while (n--) {
        int m;
        cin >> m;
        int nums[m];
        int l = 0, r = 0;
        for (int i = 0; i < m; ++i) {
            cin >> nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                if (!l) l = i;
                r = i;
            }
        }
        printf("%d\n", l >= r ? 0 : max(r - l - 1, 1));
    }
    return 0;
}