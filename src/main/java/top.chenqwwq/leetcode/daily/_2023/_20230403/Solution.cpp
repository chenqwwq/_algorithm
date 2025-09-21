//
// Created by chenqwwq on 2023/4/3.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<int> prevPermOpt1(vector<int> &arr) {
        int n = (int) arr.size();
        int p = 0;
        // 从后往前找到一个降序对
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                // 从stack中找到小于该值的位置
                int j = n-1;
                while (arr[j] >= arr[i] || arr[j] == arr[j-1]) j--;
                swap(arr[i], arr[j]);
                break;
            }
        }
        return arr;
    }
};