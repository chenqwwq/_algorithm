//
// Created by 陈炳鑫 on 2022/3/25.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int INF = 0x3f3f3f3f;

    // 双向遍历做法
//    int trap(vector<int> &height) {
//        int n = height.size();
//        vector<int> nums(n, INF);
//
//        int left = 0, right = 0;
//        for (int i = 0; i < n; ++i) {
//            left = max(left, height[i]);
//            nums[i] = min(nums[i], left);
//            right = max(right, height[n - i - 1]);
//            nums[n - i - 1] = min(nums[n - i - 1], right);
//        }
//        int ans = 0;
//        for (int i = 0; i < n; ++i) ans += (nums[i] > height[i] ? nums[i] - height[i] : 0);
//        return ans;
//    }

    int trap(vector<int> &height) {
        int n = height.size();

        // 数组模拟单调栈
        vector<int> stack(n + 1);
        int ans = 0, pos = -1;

        for (int i = 0; i < n; ++i) {
            // height[stack[pos - 1]] < height[i]
            while (pos >= 0 && height[stack[pos]] < height[i]) {
                if(pos > 0){
                    int diff = min(height[stack[pos - 1]], height[i]) - height[stack[pos]];
                    ans += (diff * (i - stack[--pos] - 1));
                }else pos--;
            }
            cout << pos << endl;
            stack[++pos] = i;
        }
        return ans;
    }
};

int main() {
    vector<int> v1{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    (new Solution)->trap(v1);
}
