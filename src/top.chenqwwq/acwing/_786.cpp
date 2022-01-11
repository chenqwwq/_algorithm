//
// Created by 陈炳鑫 on 2022/1/8.
//

#include <iostream>

using namespace std;


int quick_select(int nums[], int l, int r, int k) {
    if (l == r) {
        return nums[l];
    }
    int rr = nums[l], i = l - 1, j = r + 1;
    while (i < j) {
        while (nums[++i] < rr);
        while (nums[--j] > rr);
        if (i < j) swap(nums[i], nums[j]);
    }
    int cnt = j - l + 1;
    if (cnt >= k) return quick_select(nums, l, j, k);
    return quick_select(nums, j + 1, r, k - cnt);
}

int main() {
    int n, k;
    scanf("%d %d", &n, &k);
    if (n < k) return -1;
    int nums[n];
    for (int i = 0; i < n; ++i) scanf("%d", &nums[i]);
    printf("%d ", quick_select(nums, 0, n - 1, k));
    return 0;
}