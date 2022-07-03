//
// Created by 陈炳鑫 on 2022/3/13.
//


#include "stdc++.h"
#include "common.h"

using namespace std;


class DiscountSystem {
public:
    vector<vector<int>> activities;
    unordered_map<int, unordered_map<int, int>> userActivityCnt;
    unordered_set<int> delActId;

    DiscountSystem() {
        // NOOP
    }

    void addActivity(int actId, int priceLimit, int discount, int number, int userLimit) {
        activities.push_back({actId, priceLimit, discount, number, userLimit});
    }

    void removeActivity(int actId) {
        delActId.insert(actId);
    }

    int consume(int userId, int cost) {
        activities.
    }
};