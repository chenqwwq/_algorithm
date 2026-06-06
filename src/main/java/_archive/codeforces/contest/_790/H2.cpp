//
// Created by 陈炳鑫 on 2022/5/11.
//


#include <iostream>
#include <cstring>


using namespace std;

typedef long long ll;

const int maxn = 2e5+1;
int n;
ll tree[maxn];

int lowbit(int i) {
    return i & -i;
}

void update(int a) {
    while (a <= n) {
        tree[a]++;
        a += lowbit(a);
    }
}

ll get(int a) {
    ll ans = 0;
    while (a > 0) {
        ans += tree[a];
        a -= lowbit(a);
    }
    return ans;
}

int main() {
    int t, num;
    cin >> t;
    while (t--) {
        cin >> n;
        memset(tree, 0x00, sizeof(tree));
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            cin >> num;
            ans += get(n) - get(num - 1);
            update(num);
        }
        printf("%lld\n", ans);
    }
    return 0;
}