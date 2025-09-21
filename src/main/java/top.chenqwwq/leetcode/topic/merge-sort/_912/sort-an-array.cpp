//
// Created by 陈炳鑫 on 2022/4/2.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> sortArray(vector<int> &nums) {
        quick_sort(nums, 0, nums.size() - 1);
        return nums;
    }

    void quick_sort(vector<int> &nums, int l, int r) {
        if (l >= r) return;
        int pivot = nums[l], i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= pivot) j--;
            while (i < j && nums[i] <= pivot) i++;
            swap(nums[i], nums[j]);
        }
        nums[l] = nums[i];
        nums[i] = pivot;
        quick_sort(nums, l, i - 1);
        quick_sort(nums, i + 1, r);
    }


    void sort(vector<int> &nums, vector<int> &back, int l, int r) {
        if (r <= l) return;
        int mid = (l + r) >> 1;
        sort(nums, back, l, mid);
        sort(nums, back, mid + 1, r);
        int pos = l, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) back[pos++] = nums[i++];
            else back[pos++] = nums[j++];
        }
        while (i <= mid) back[pos++] = nums[i++];
        while (j <= r) back[pos++] = nums[j++];
        memcpy(&nums[l], &back[l], sizeof(int) * (r - l + 1));
    }
};
