//
// Created by chenqwwq on 2023/3/23.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<bool> checkArithmeticSubarrays(vector<int> &nums, vector<int> &l, vector<int> &r) {
        // 检查是否为等差数列
        // 避免排序,采用等差数列的特性使用 set 统计
        auto check = [&](int ll, int rr) -> bool {
            if (ll == rr) return true;
            int mmin = *min_element(nums.begin() + ll, nums.begin() + rr + 1);
            int mmax = *max_element(nums.begin() + ll, nums.begin() + rr + 1);
            // 相等的时候所有数列都应该向灯
            if (mmin == mmax) {
                while (ll <= rr) {
                    if (nums[ll] != mmin) return false;
                    ll++;
                }
            }
            int cnt = rr - ll;
            if (((mmax - mmin) % cnt) != 0) return false;// 无法整除
            int gap = (mmax - mmin) / cnt;
            vector<bool> hash(cnt + 1, false);
            for (int i = ll; i <= rr; i++) {
                if ((nums[i] - mmin) % gap != 0) return false;
                int idx = (nums[i] - mmin) / gap;
                if (hash[idx]) return false;
                hash[idx] = true;
            }
            return true;
        };
        int n = (int) l.size();
        vector<bool> ans(n);
        for (int i = 0; i < n; i++) {
            ans[i] = check(l[i], r[i]);
        }
        return ans;
    }

};

int main() {
    vector<int> nums{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10};
    vector<int> l{8, 7}, r{9, 10};
    (new Solution)->checkArithmeticSubarrays(nums, l, r);
}