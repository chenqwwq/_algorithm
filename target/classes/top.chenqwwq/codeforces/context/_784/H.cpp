//
// Created by 陈炳鑫 on 2022/4/23.
//


#include <iostream>
#include <vector>

using namespace std;

void printBinary(int x) {
    //<?>中的参数是指定输出多少位
    cout << bitset<sizeof(x) * 8>(x) << endl;//int占4字节，一个字节8位，最终输出的是32个0或1
}

int main() {
    int n;
    cin >> n;
    while (n--) {
        int m, k;
        cin >> m >> k;
        int num;
        vector<int> bit(31,0);
        for (int j = 0; j < m; ++j) {
            cin >> num;
            for (int i = 0; i <= 30; ++i){
                bit[i] += num >>i & 1;
            }
        }
        int ans = 0;
        for (int i = 30; i >= 0; --i) {
            if (bit[i] >= m) ans |= (1 << i);
            else if (k >= m - bit[i]) {
                ans |= (1 << i);
                k -= (m - bit[i]);
            }
        }
        printf("%d\n",ans);
    }
    return 0;
}