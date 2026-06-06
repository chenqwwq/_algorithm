//
// Created by chenqwwq on 2024/5/26.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int duplicateNumbersXOR(vector<int> &nums) {
        int hash[51];
        memset(hash, 0, sizeof(hash));
        for (auto num: nums)hash[num]++;
        int ans = 0;
        for (int i = 0; i <= 50; i++) {
            if (hash[i] == 2)ans ^= i;
        }
        return ans;
    }
};

int main() {
    vector<int> num{10, 10, 18, 18, 7};
    (new Solution)->duplicateNumbersXOR(num);
}

