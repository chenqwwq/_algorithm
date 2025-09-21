//
// Created by chenqwwq on 2023/3/21.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<double> convertTemperature(double celsius) {
        return vector<double>{celsius + 273.15,celsius * 1.80 + 32.00};
    }
};