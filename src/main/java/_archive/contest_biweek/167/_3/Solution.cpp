//
// Created by chenqwwq on 2025/10/12.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class ExamTracker {
public:
    vector<int> ts;
    vector<long long> sc;

    ExamTracker() {
    }

    void record(int time, int score) {
        ts.push_back(time);
        sc.push_back((sc.size() > 0 ? sc[sc.size() - 1] : 0) + score);
    }

    long long totalScore(int startTime, int endTime) {
        auto l = lower_bound(ts.begin(), ts.end(), startTime) - ts.begin();
        auto r = upper_bound(ts.begin(), ts.end(), endTime) - ts.begin() - 1;

        if (r < l) return 0;
        return sc[r] - (l > 0 ? sc[l - 1] : 0);
    }
};