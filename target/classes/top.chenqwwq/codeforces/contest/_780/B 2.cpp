//
// Created by chenqwwq on 2022/5/20.
//


#include <iostream>
#include <algorithm>

using namespace std;


int nums[(int) 2e5 + 1];
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t, n;
    cin >> t;
    while (t--) {
        cin >> n;
        for (int i = 0; i < n; ++i) cin >> nums[i];
        sort(nums, nums + n);
        printf("%s\n", nums[n - 1] - nums[n - 2] < 2 ? "YES" : "NO");
    }
    return 0;
}