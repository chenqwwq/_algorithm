//
// Created by chenqwwq on 2024/9/18.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int latestTimeCatchTheBus(vector<int> &buses, vector<int> &passengers, int capacity) {
        // 排序
        sort(buses.begin(), buses.end(), greater<>());
        sort(passengers.begin(), passengers.end(), greater<>());

        // 遍历递进
        int l = 0, r = passengers.size();
        for (int i = 0; i < buses.size() - 1; i++) {
            // 找到从 l 开始第一个大于 bus 的乘客,l -> target - 1的用户就是可以乘坐的
            // l 往右移动 capacity 个
            int cur = 0;
            while (l < r && passengers[l] <= buses[i] && cur++ < capacity) {
                l++;
            }
        }

        int t = buses[buses.size() - 1];  // 最后一辆车的到达时间
        int cnt = r - l + 1;        // 剩下的数量
        if(cnt < capacity){     // 载客量大于当前剩余乘客,可以全部带走
        }
    }

    int dfs(int l, int r, vector<int> &ps) {

    }
};