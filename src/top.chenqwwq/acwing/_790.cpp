//
// Created by 陈炳鑫 on 2022/1/14.
//

#include "iostream"

using namespace std;

typedef long long LL;

int nums[100010];
int tmp[100010];

// 在合并的过程中需要判断逆序对的个数
LL fork_join(int l, int r) {
    if (l >= r) return 0;
    int mid = (l + r) >> 1;
    LL ans = fork_join(l, mid) + fork_join(mid + 1, r);

    int i = 0, x = l, y = mid + 1;
    // 左边应该比右边的小
    while (x <= mid && y <= r) {
        if (nums[x] > nums[y]) {
            tmp[i++] = nums[y++];
            ans += (mid - x + 1);
        } else {
            tmp[i++] = nums[x++];
        }
    }

    while (x <= mid) tmp[i++] = nums[x++];
    while (y <= r) tmp[i++] = nums[y++];

    for (int j = l, k = 0; j <= r; ++j, ++k) nums[j] = tmp[k];
    return ans;
}

int main() {
    // 尝试使用归并的形式
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &nums[i]);
    printf("%lld\n", fork_join(0, n - 1));
    return 0;
}