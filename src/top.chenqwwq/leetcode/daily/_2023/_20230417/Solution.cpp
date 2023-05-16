//
// Created by chenqwwq on 2023/4/18.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int days[13]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    int countDaysTogether(string arriveAlice, string leaveAlice, string arriveBob, string leaveBob) {
        for (int i = 1; i <= 12; i++) {
            days[i] += days[i - 1];
        }
        int m1 = (arriveAlice[0] - '0') * 10 + (arriveAlice[1] - '0');
        int m2 = (leaveAlice[0] - '0') * 10 + (leaveAlice[1] - '0');
        int m3 = (arriveBob[0] - '0') * 10 + (arriveBob[1] - '0');
        int m4 = (leaveBob[0] - '0') * 10 + (leaveBob[1] - '0');
        int d1 = (arriveAlice[3] - '0') * 10 + (arriveAlice[4] - '0');
        int d2 = (leaveAlice[3] - '0') * 10 + (leaveAlice[4] - '0');
        int d3 = (arriveBob[3] - '0') * 10 + (arriveBob[4] - '0');
        int d4 = (leaveBob[3] - '0') * 10 + (leaveBob[4] - '0');
        int c1 = days[m1 - 1] + d1;
        int c2 = days[m2 - 1] + d2;
        int c3 = days[m3 - 1] + d3;
        int c4 = days[m4 - 1] + d4;
        return (c2 < c3 || c1 > c4) ? 0 : min(c2, c4) - max(c1, c3) + 1;
    }
};