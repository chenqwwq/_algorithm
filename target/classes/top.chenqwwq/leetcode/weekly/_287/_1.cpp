//
// Created by 陈炳鑫 on 2022/4/3.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> nums{60, 15, 5, 1};
    int total = 23 * 60 + 59;

    int convertTime(string current, string correct) {
        int start = getMinute(current), end = getMinute(correct);
        cout << start << ":" << end << endl;
        return get(end < start ? total + end - start : end - start);
    }

    int get(int diff) {
        int ans = 0;
        for (int i = 0; i < 4; ++i) {
            ans += diff / nums[i];
            diff %= nums[i];
        }
        return ans;
    }

    int getMinute(string str) {
        return (str[0] - '0') * 60 * 10 + (str[1] - '0') * 60 + (str[3] - '0') * 10 + (str[4] - '0');
    }
};

int main() {
    (new Solution)->convertTime("02:30",
                                "04:35");
}
