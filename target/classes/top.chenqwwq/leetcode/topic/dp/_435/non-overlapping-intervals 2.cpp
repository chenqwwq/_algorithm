//
// Created by chenqwwq on 2022/5/18.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>> &intervals) {
        if (intervals.empty()) return 0;
        int n = (int) intervals.size();
        sort(intervals.begin(), intervals.end(), [](const vector<int> &a, const vector<int> &b) -> bool {
            return a[1] < b[1];
        });
        int r = -5e4 - 1, ans = 0;
        for (auto i: intervals) {
            if (i[0] >= r) {
                ans++;
                r = i[1];
            }
        }
        return n - ans;
    }
};

int main(){
    double age = 1e9;
    cout << age;
}