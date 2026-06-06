//
// Created by 陈炳鑫 on 2022/2/27.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;
typedef long long ll;

class Solution {
public:
    long long minimumTime(vector<int> &time, int totalTrips) {
        int mmin = INT_MAX;
        for (int t: time) mmin = min(mmin, t);
        long long l = 0;
        long long  r = 1L * totalTrips * mmin;
        while (l < r) {
            long long mid = (l + r) >> 1;
            long long total = 0;
            for (int t: time) total += mid / t;
            if (total < totalTrips) l = mid + 1;
            else r = mid;
        }
        return l;
    }
};

int main(){
    vector<int> p1{10000};
    (new Solution)->minimumTime(p1,10000000);
}