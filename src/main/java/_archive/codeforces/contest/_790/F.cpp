//
// Created by 陈炳鑫 on 2022/5/10.
//


#include <iostream>
#include <unordered_map>
#include <vector>
#include <algorithm>

using namespace std;

unordered_map<int, int> mmap;
vector<int> nums;

int main() {
    int t, n, k, num;
    cin >> t;
    while (t--) {
        nums.clear();
        mmap.clear();
        cin >> n >> k;
        while (n--) {
            cin >> num;
            if (++mmap[num] == k) {
                nums.push_back(num);
            }
        }
        if (nums.empty()) {
            printf("%d\n", -1);
            continue;
        }
        sort(nums.begin(), nums.end(), less<>{});
        int al = nums[0], ar = nums[0];
        for (int l = 0; l < nums.size();) {
            int r = l;
            while (r + 1 < nums.size() && nums[r + 1] == nums[r] + 1) {
                r++;
            }
            if (nums[r] - nums[l] > ar - al) {
                ar = nums[r];
                al = nums[l];
            }
            l = max(r, l + 1);
        }
        printf("%d %d\n", al, ar);
    }
    return 0;
}