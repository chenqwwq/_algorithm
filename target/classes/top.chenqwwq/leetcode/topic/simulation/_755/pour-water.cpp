//
// Created by 陈炳鑫 on 2022/3/4.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> pourWater(vector<int> &heights, int volume, int k) {
        int curr = 0, n = heights.size();
        while (curr++ < volume) {
            heights[k]++;
            bool left = false;
            for (int i = 1; k - i >= 0; ++i) {
                if (heights[k - i] >= heights[k - i + 1] - 1) break;
                left = true;
                heights[k - i]++;
                heights[k - i + 1]--;
            }

            if (!left) continue;
            for (int i = 1; k + i < n; ++i) {
                if (heights[k + i] >= heights[k + i - 1] - 1) break;
                heights[k + i]++;
                heights[k + i - 1]--;
            }
        }
        return heights;
    }
};

int main() {
//    输入：heights = [2,1,1,2,1,2,2], V = 4, K = 3
//    输出：[2,2,2,3,2,2,2]
    vector<int> p1{2, 1, 1, 2, 1, 2, 2};
    const vector<int> &water = (new Solution)->pourWater(p1, 4, 3);
    for (int ans: water) cout << ans << " ";

}