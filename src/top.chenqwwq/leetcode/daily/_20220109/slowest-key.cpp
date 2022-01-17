//
// Created by chenqwwq on 2022/1/9.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    char slowestKey(vector<int> &releaseTimes, string keysPressed) {
        int n = keysPressed.length();
        char ans = keysPressed[0];
        int max = releaseTimes[0];
        for (int i = 1; i < n; ++i) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if(time > max || (time == max && keysPressed[i] > ans)){
                max = time;
                ans = keysPressed[i];
            }
        }
        return ans;
    }
};