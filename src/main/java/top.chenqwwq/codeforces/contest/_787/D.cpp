//
// Created by 陈炳鑫 on 2022/5/6.
//


#include <iostream>

using namespace std;

const int maxn = 2 * 1e5 + 1;

int nums[maxn], qu[maxn];
// 1表示是叶子 -1表示不是叶子 0表示已经访问过
int leaf[maxn];

int main() {
    leaf[0] = 0;
    int n;
    cin >> n;
    int m, cnt;
    while (n--) {
        cin >> m;
        cnt = m;
        for (int i = 1; i <= m; ++i) leaf[i] = 1;
        for (int i = 0; i < m; ++i) {
            cin >> nums[i + 1];
            if (leaf[nums[i + 1]] == 1) cnt--;
            leaf[nums[i + 1]] = -1;
        }
        if(m == 1){
            printf("1\n1\n1\n\n");
            continue;
        }
        printf("%d\n", cnt);
        int pos;
        for (int i = 1; i <= m; ++i) {
            if (leaf[i] != 1) continue;
            pos = 0;
            for (int j = i; leaf[j] != 0; j = nums[j]) {
                qu[pos++] = j;
                leaf[j] = 0;
            }
            printf("%d\n", pos);
            --pos;
            printf("%d", qu[pos]);
            while (--pos >= 0) printf(" %d", qu[pos]);
            cout << endl;
        }
        cout << endl;
    }
    return 0;
}