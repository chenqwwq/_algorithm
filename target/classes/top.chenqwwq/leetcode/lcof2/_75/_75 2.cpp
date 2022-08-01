//
// Created by chenqwwq on 2022/1/6.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        vector<int> counts(1001, 0);
        for (auto& n : arr1) {
            counts[n]++;
        }

        int i = 0;
        // 排序 arr2 内的数字
        for (const auto& n : arr2) {
            while (counts[n] > 0) {
                arr1[i++] = n;
                counts[n]--;
            }
        }
        // 排序剩下的数字
        for (int j = 0; j < counts.size(); ++j) {
            while (counts[j] > 0) {
                arr1[i++] = j;
                counts[j]--;
            }
        }
        return arr1;
    }
};