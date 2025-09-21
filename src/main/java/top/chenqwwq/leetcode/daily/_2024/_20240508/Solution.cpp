//
// Created by chenqwwq on 2024/5/8.
//

#include "bits/stdc++.h"
#include "iostream"

using namespace std;
typedef long long ll;

class Solution {
public:
    int wateringPlants(vector<int> &plants, int capacity) {
        int n = plants.size();
        int ans = 0, cur = capacity;
        for (int i = 0; i < n; i++) {
            if (cur >= plants[i]) {
                cur -= plants[i];
                ans += 1;
            } else if (capacity >= plants[i]) {
                cur = capacity - plants[i];
                ans += (i << 1) + 1;
            }else if(capacity < plants[i]) return -1;
        }
        return ans;
    }
};