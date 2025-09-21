//
// Created by chenqwwq on 2024/5/20.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int getWinner(vector<int> &arr, int k) {
        int n = arr.size();
        if (k >= n) return *max_element(arr.begin(), arr.end());

        int idx = 0, cur = 0;
        for (int i = 1; i < n; ++i %= n) {
            if (arr[i] > arr[idx]) {
                idx = i;
                cur = 1;
            } else {
                cur++;
            }
            if(cur >= k) return arr[idx];
        }
        return -1;
    }
};

int main(int argc,char** argv){
    vector<int> l = {2,1,3,5,4,6,7};

    (new Solution)->getWinner(l,2);
}