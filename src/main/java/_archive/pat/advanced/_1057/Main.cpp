//
// Created by 陈炳鑫 on 2022/5/4.
//


#include <iostream>
#include <stack>

#define lowbit(i) i & -i;

using namespace std;

// 基础是使用二分+前缀和确定前半值，使用树状数组加速前缀和
const int maxn = 1e5;
int tree[maxn];         // 树状数组统计小于i的个数
stack<int> sta;

void update(int i, int v) {
    while (i < maxn) {
        tree[i] += v;
        i += lowbit(i);
    }
}

// 获取 p 之前的和
int getsum(int pos) {
    int sum = 0;
    while (pos >= 1) {
        sum += tree[pos];
        pos -= lowbit(pos);
    }
    return sum;
}

void printMedian() {
    int l = 1, r = maxn, mid, k = ((int)sta.size() + 1) >> 1;
    while (l < r) {
        mid = (l + r) >> 1;
        if (getsum(mid) >= k) r = mid;
        else l = mid + 1;
    }
    printf("%d\n", l);
}

int main() {
    int n;
    string op;
    cin >> n;
    getline(cin, op);
    while (n--) {
        getline(cin, op);
        if (op == "PeekMedian") {
            if (sta.empty()) printf("Invalid\n");
            else printMedian();
        } else if (op == "Pop") {
            if (sta.empty()) printf("Invalid\n");
            else {
                int num = sta.top();
                sta.pop();
                update(num, -1);
                printf("%d\n", num);
            }
        } else {
            int num = atoi(op.substr(5).c_str());
            sta.push(num);
            update(num, 1);
        }
    }
    return 0;
}