//
// Created by chenqwwq on 2022/1/18.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int findMinDifference(vector<string> &timePoints) {
        auto n = timePoints.size();
        if(n < 2){
            return -1;
        }
        vector<int> times;
        times.reserve(timePoints.size());
        for (const string &time: timePoints) {
            times.push_back(getMinute(time));
        }
        sort(times.begin(), times.end());
        int ans = INT_MAX;
        for (int i = 0; i < n - 1; i++) {
            ans = min(ans, times[i + 1] - times[i]);
        }
        return min(ans, times[0] + 24 * 60 - times[n-1]);
    }

    int getMinute(const string &time) {
        auto idx = time.find(':');
        return stoi(time.substr(0, idx)) * 60 + stoi(time.substr(idx + 1));
    }
};

int main(){
    vector<string> p1{"00:00","04:00","22:00"};
    (new Solution)->findMinDifference(p1);
}