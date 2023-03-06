//
// Created by chenqwwq on 2022/12/19.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

// ranks 表示每个点的秩,它表示以该节点为根的树的高度的上界
vector<int> nums, ranks;

void init(int n) {
    ranks.resize(n);
    nums.resize(n);
    for (int i = 0; i < n; i++) {
        nums[i] = i;
        ranks[i] = 0;
    }
}

// 路径压缩
int find(int n) {
    if (n >= nums.size()) return -1;
    if (nums[n] == n) return n;
    nums[n] = find(nums[n]);
    return nums[n];
}

// 按秩合并
void _union(int a, int b) {
    int n1 = find(a), n2 = find(b);
    if (ranks[n1] < ranks[n2]) nums[n1] = n2;
    else {
        nums[n2] = n1;
        if (ranks[n1] == ranks[n2]) ranks[n1]++;
    }
}

// 普通查询
//int find(int n) {
//    if (n >= nums.size()) return -1;
//    return nums[n] == n ? n : nums[n];
//}

// 普通合并
//void _union(int a, int b) {
//    int n1 = find(a), n2 = find(b);
//    if (n1 == n2) return;
//    nums[n1] = n2;
//}
//
