//
// Created by 陈炳鑫 on 2022/3/20.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int countCollisions(string road) {
        auto n = road.size();
        int ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (road[i] == 'L') continue;
            if (road[i] == 'R') {
                if (road[i + 1] == 'R') continue;
                else {
                    if (road[i + 1] == 'L') {
                        ans += 2;
                        road[i + 1] = 'S';
                    } else ans += 1;
                    int cur = i;
                    while (--cur >= 0) {
                        if (road[cur] == 'R') ans++;
                        else break;
                    }
                }
            }
            if (road[i] == 'S') {
                if (road[i + 1] == 'L') {
                    ans += 1;
                    road[i + 1] = 'S';
                }
            }
        }
        return ans;
    }
};

int main() {
    (new Solution)->countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR");
    // 1
}