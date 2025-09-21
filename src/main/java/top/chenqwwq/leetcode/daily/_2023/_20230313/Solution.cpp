//
// Created by chenqwwq on 2023/3/13.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minNumberOfHours(int a, int b, vector<int> &energy, vector<int> &experience) {
        int n = (int) energy.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c = max(0, energy[i] - a + 1), d = max(experience[i] - b + 1, 0);
            ans += c + d;
            a = a + c - energy[i];
            b = b + d + experience[i];
        }
        return ans;
    }
};

int main() {

    vector<int> a{1, 4, 3, 2}, b{2, 6, 3, 1};
    (new Solution)->minNumberOfHours(5, 3, a, b);
}