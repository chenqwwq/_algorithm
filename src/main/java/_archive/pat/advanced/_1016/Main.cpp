//
// Created by 陈炳鑫 on 2022/4/21.
//


#include <iostream>
#include <utility>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

struct Record {
    string name;
    bool off;
    int day, hour, minute;

    Record() {}

    Record(string name, bool off, int day, int hour, int minute) : name(std::move(name)), off(off),
                                                                   day(day),
                                                                   hour(hour), minute(minute) {}
};

int main() {
    int toll[24];
    for (int &i: toll) scanf("%d", &i);
    int n;
    scanf("%d", &n);
    string name, word;
    int month, day, hour, minute;
    vector<string> ns;
    unordered_map<string, vector<Record *>> records;

    for (int i = 0; i < n; ++i) {
        cin >> name;
        scanf("%d:%d:%d:%d", &month, &day, &hour, &minute);
        cin >> word;
        if (records.find(name) == records.end()) {
            records[name] = {};
            ns.push_back(name);
        }
        records[name].push_back(new Record(name, word == "off-line", day, hour, minute));
    }

    auto cmp = [&](Record *r1, Record *r2) {
        if (r1->day == r2->day) {
            if (r1->hour == r2->hour) {
                return r1->minute < r2->minute;
            }
            return r1->hour < r2->hour;
        }
        return r1->day < r2->day;
    };

    auto charge = [&](int d1, int h1, int m1, int d2, int h2, int m2) -> pair<int, int> {
        int total = 0, minute = 0;
        if (d1 == d2) {
            if (h1 == h2) {
                return {m2 - m1, (m2 - m1) * toll[h2]};
            }
            minute += (60 - m1);
            total += (60 - m1) * toll[h1];
            for (int i = h1 + 1; i < h2; ++i) {
                minute += 60;
                total += 60 * toll[i];
            }
            return {minute + m2, total + m2 * toll[h2]};
        }
        minute += 60 - m1;
        total += (60 - m1) * toll[h1];
        for (int i = h1 + 1; i <= 23; ++i) {
            minute += 60;
            total += 60 * toll[i];
        }
        for (int i = d1 + 1; i < d2; ++i) {
            for (int j = 0; j <= 23; ++j) {
                minute += 60;
                total += 60 * toll[j];
            }
        }
        for (int i = 0; i < h2; ++i) {
            minute += 60;
            total += 60 * toll[i];
        }
        return {minute + m2, total + m2 * toll[h2]};
    };

    sort(ns.begin(), ns.end());
    for (auto &cur: ns) {
        auto rs = records[cur];
        sort(rs.begin(), rs.end(), cmp);
        bool match = false;
        double amount = 0;
        for (int i = 0; i < rs.size() - 1;) {
            if (rs[i]->off || !rs[i + 1]->off) {
                i++;
                continue;
            }
            if (!match) {
                printf("%s %02d\n", cur.c_str(), month);
                match = true;
            }
            int d1 = rs[i]->day, h1 = rs[i]->hour, m1 = rs[i]->minute;
            int d2 = rs[i + 1]->day, h2 = rs[i + 1]->hour, m2 = rs[i + 1]->minute;
            auto res = charge(d1, h1, m1, d2, h2, m2);
            amount += res.second / (double) 100;
            printf("%02d:%02d:%02d %02d:%02d:%02d %d $%.2lf\n", d1, h1, m1, d2, h2, m2, res.first,
                   res.second / (double) 100);
            i += 2;
        }
        if(match){
            printf("Total amount: $%.2lf\n", amount);
        }
    }
    return 0;
}