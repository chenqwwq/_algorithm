//
// Created by 陈炳鑫 on 2022/1/9.
//

#include "iostream"

using namespace std;

void merge_sort(int nums[], int i, int j, int tmp[]) {
    if (i >= j) {
        return;
    }
    int mid = (i + j) >> 1;
    merge_sort(nums, i, mid, tmp);
    merge_sort(nums, mid + 1, j, tmp);
    int x = i, y = mid + 1, pos = 0;
    while (x <= mid && y <= j) {
        if (nums[x] < nums[y]) tmp[pos++] = nums[x++];
        else tmp[pos++] = nums[y++];
    }
    while (x <= mid) tmp[pos++] = nums[x++];
    while (y <= j) tmp[pos++] = nums[y++];

    for (int k = i, l = 0; k <= j; ++k, ++l) nums[k] = tmp[l];
}

int main() {
    int n;
    scanf("%d", &n);
    int nums[n];
    for (int i = 0; i < n; ++i) scanf("%d", &nums[i]);
    merge_sort(nums, 0, n - 1, new int[n]);
    for (int i = 0; i < n; ++i) printf("%d ", nums[i]);
}