//
// Created by 陈炳鑫 on 2022/2/19.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> pancakeSort(vector<int> &arr) {
        int n = arr.size();
        vector<int> ans;
        for (int i = n - 1; i >= 0; --i) {
            if (arr[i] == i + 1) continue;
            for (int j = i - 1; j >= 0; --j) {
                if (arr[j] == i + 1) {
                    reorder(arr, 0, j);
                    ans.push_back(j+1);
                    reorder(arr, 0, i);
                    ans.push_back(i+1);
                }
            }
        }
        return ans;
    }

    void reorder(vector<int> &arr, int i, int j) {
        while (i < j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
            i++;
            j--;
        }
    }
};