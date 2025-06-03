//
// Created by chenqwwq on 2025/5/18.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {

    // 获取 num 的数位和
    static int getN(int num) {
        int cur = 0;
        while (num) {
            cur += num % 10;
            num /= 10;
        }
        return cur;
    }

public:

    // 元数组
    vector<int> fa;
    int cnt;

    int minSwaps(vector<int> &nums) {
        auto n = nums.size();
        // 根据排序前后的对应下标建图
        vector<int> newNums(nums);

        // 按照数位和排序,相同则较小的在前面
        sort(newNums.begin(), newNums.end(), [](int n1, int n2) {
            int a = getN(n1), b = getN(n2);
            if (a != b) return a < b;
            return n1 < n2;
        });

        // 元素值和排序后的下标
        unordered_map<int, int> num2Idx;
        for (int i = 0; i < n; i++) {
            num2Idx[newNums[i]] = i;
        }

        // 初始化并查集
        fa = vector<int>(n);
        for (int i = 0; i < n; i++)fa[i] = i;
        cnt = n;
        for (int i = 0; i < n; i++) {
            merge(i, num2Idx[nums[i]]);
        }

        return n - cnt;
    }


    // 做路径压缩
    int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    // 最基础的合并不需要按秩
    bool merge(int f, int t) {
        int a = find(f), b = find(t);
        if (a == b) return false;
        fa[a] = b;
        cnt--;
        return true;
    }
};

int main() {
    vector<int> nums{2, 3, 1};
    (new Solution)->minSwaps(nums);
}