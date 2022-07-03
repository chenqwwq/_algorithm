//
// Created by chenqwwq on 2022/5/24.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

typedef long long ll;
int mod = (int) 1e9 + 7;

class Solution {
public:
    int sumSubarrayMins(vector<int> &arr) {
        int n = (int) arr.size();
        int nums[n], pos = 0;
        ll ans = 0;
        for (int i = 0; i < n; ++i) {
            if (!pos || arr[nums[pos - 1]] < arr[i]) {
                nums[pos++] = i;
            } else {
                while (pos && arr[nums[pos - 1]] >= arr[i]) {
                    int idx = nums[--pos];
                    ans = (ans + 1l * (idx - (pos > 0 ? nums[pos - 1] : -1)) * (i - idx) * arr[idx] % mod) % mod;
                }
                nums[pos++] = i;
            }
        }
        while (pos) {
            int idx = nums[--pos];
            ans = (ans + 1l * (idx - (pos > 0 ? nums[pos - 1] : -1)) * (n - idx) * arr[idx] % mod) % mod;
        }
        return (int) ans;
    }
};
