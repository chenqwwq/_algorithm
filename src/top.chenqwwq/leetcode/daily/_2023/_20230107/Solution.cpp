//
// Created by chenqwwq on 2023/1/7.
//


#include "bits/stdc++.h"
#include "iostream"


using namespace std;

typedef long long ll;

class Solution {
public:
    int inf = 0x3f3f3f3f;

    int minOperations(vector<int> &nums, int x) {
        // 逆向思维就是从中间减去某个连续数组 剩余的值为x
        int target = -x, n = (int) nums.size();
        for (int num: nums) target += num;
        if (target < 0) return -1;
        if (target == 0) return n;
        int ans = -1;
        int l = 0, r = 0,cur = 0;
        while (r < n){
            cur += nums[r];
            while (cur > target) cur -= nums[l++];
            if(cur == target) ans = max(ans,r - l + 1);
            r++;
        }
        return ans < 0 ? -1 : n - ans;
    }

//    int minOperations(vector<int> &nums, int x) {
//        int n = (int) nums.size();
//        map<ll, int> _map;
//        ll sum = 0;
//        _map[0] = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            sum += nums[i];
//            _map[sum] = n - i;
//        }
//        if (sum < x) return -1;
//        int ans = inf;
//        sum = 0;
//        if (_map.find(x) != _map.end()) ans = _map[x];
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//            if (x < sum) break;
//            ll target = x - sum;
//            if (_map.find(target) == _map.end()) continue;
//            int t = i + 1 + _map[target];
//            if (t > n || t > ans) continue;
//            ans = t;
//        }
//        return ans == inf ? -1 : ans;
//    }
};

int main() {
    vector<int> nums{1, 1, 4, 2, 3};
    (new Solution)->minOperations(nums, 5);
}