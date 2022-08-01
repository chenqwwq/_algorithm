//
// Created by chenqwwq on 2022/1/7.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

// 快排的时间复杂度为 logN,不稳定
void quick_sort(int nums[], int l, int r) {
    if (l >= r) {
        return;
    }
    int x = nums[l], i = l - 1, j = r + 1;
    while (i < j) {
        while (nums[++i] < x);
        while (nums[--j] > x);
        if (i < j) {
            swap(nums[i], nums[j]);
        }
    }
    quick_sort(nums, l, j);
    quick_sort(nums, j + 1, r);
}

// 归并排序的时间复杂度为 logN,稳定
void merge_sort(int nums[], int l, int r, int tmp[]) {
    if (l >= r) {
        return;
    }
    int mid = (l + r) >> 1;
    merge_sort(nums, l, mid, tmp);
    merge_sort(nums, mid + 1, r, tmp);

    int k = 0, x = l, y = mid + 1;
    while (x <= mid && y <= r) {
        if (nums[x] < nums[y]) tmp[k++] = nums[x++];
        else tmp[k++] = nums[y++];
    }
    while (x <= mid) tmp[k++] = nums[x++];
    while (y <= r) tmp[k++] = nums[y++];

    for (int i = l,j = 0; i <= r; ++i,++j) {
        nums[i] = tmp[j];
    }
}