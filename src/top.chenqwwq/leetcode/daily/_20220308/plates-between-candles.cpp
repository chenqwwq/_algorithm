//
// Created by 陈炳鑫 on 2022/3/8.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:


    vector<int> platesBetweenCandles(string s, vector<vector<int>> &queries) {
        int n = s.length();
        vector<int> ps(n + 2, 0);
        for (int i = 1, sum = 0; i < n + 1; ++i) {
            if (s[i - 1] == '*') sum++;
            ps[i] = sum;
        }
        ps[n + 1] = ps[n ] + 1;

        int m = queries.size();
        vector<int> ans(m, 0);
        for (int i = 0; i < m; ++i) {
            int l = queries[i][0], r = queries[i][1];
            int ll = left(ps, l + 1, r + 1), rr = right(ps, l + 1, r + 1);
            ans[i] = rr <= ll ? 0 : ps[rr - 1] - ps[ll];
        }
        return ans;
    }

    int right(vector<int> nums, int l, int r) {
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[r] - nums[mid - 1] < r - mid + 1) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    int left(vector<int> nums, int l, int r) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] - nums[l - 1] < mid - l + 1) r = mid;
            else l = mid + 1;
        }
        return r;
    }
};

int main() {
    string s = "*|*||||**|||||||*||*||*||**|*|*||*";
    vector<vector<int>> nums{{2, 33},
                             {5, 9}};
    (new Solution)->platesBetweenCandles(s, nums);

//    vector<int> v1{1, 1, 2, 3, 4, 5, 6};
//    (new Solution)->right(v1, 0, v1.size() - 1);

}