//
// Created by chenqwwq on 2024/7/13.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    long long maximumPoints(vector<int>& enemyEnergies, int currentEnergy) {
        auto mn = *min_element(enemyEnergies.begin(),enemyEnergies.end()).base();
        if (currentEnergy < mn) {
            return 0;
        }
        long long s = reduce(enemyEnergies.begin(), enemyEnergies.end(), 0LL);
        return (currentEnergy + s - mn) / mn;
    }
};