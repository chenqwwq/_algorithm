//
// Created by chenqwwq on 2022/1/18.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class MyCalendar {
    // <start,end>
    map<int, int> hash;
public:
    MyCalendar() {
    }

    bool book(int start, int end) {
        // 找到第一个大于等于start的
        auto iter = hash.lower_bound(start);
        if (iter != hash.end() && (iter->first < end)) return false;
        if(iter != hash.begin() && (--iter)->second > start) return false;
        hash[start] = end;
        return true;
    }
};