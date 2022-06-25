//
// Created by chenqwwq on 2022/5/24.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

// 分区算法
// 以默认的首元素分割数组，左边小于该值，右边大于该值
int basic_part(vector<int> &nums) {
    int n = (int) nums.size();
    int pos = 0;
    for (int i = 1; i < n; ++i) {
        if (nums[i] <= nums[pos]) {
            if (pos++ != i) swap(nums[i], nums[pos]);
        }
    }
    swap(nums[pos], nums[0]);
    return pos;
}

// 快速排序的基础，左右分别开始扫描
int quick_part(vector<int> &nums) {
    int n = (int) nums.size();
    int pivot = nums[0], l = -1, r = n;
    while (l < r) {
        while (--r > l && nums[r] >= pivot) {}
        while (++l < r && nums[l] <= pivot) {}
        if (l < r) swap(nums[l], nums[r]);
    }
    if (r >= 0 && r < n)swap(nums[0], nums[r]);
    return r;
}

void three_way_part(vector<int> &nums, int target) {
    int n = (int) nums.size();
    int l = 0, r = n - 1, p = 0;
    while (p < r) {
        if (nums[p] < target) {
            swap(nums[p++], nums[l++]);
        } else if (nums[p] > target) {
            swap(nums[p], nums[r--]);
        } else p++;
    }
}