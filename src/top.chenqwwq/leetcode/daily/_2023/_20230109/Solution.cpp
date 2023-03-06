//
// Created by chenqwwq on 2023/1/9.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int reinitializePermutation(int n) {
        if (n <= 2) return 1;
        vector<int> perm(n), arr(n), target(n);
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            target[i] = i;
        }
        arr[0] = 0;
        arr[n - 1] = n - 1;

        int ans = 0;
        while (!eq(arr, target)) {
            ans++;
            for (int i = 1; i < n - 1; i++) {
                if (i & 1) arr[i] = perm[(n >> 1) + ((i - 1) >> 1)];
                else arr[i] = perm[i >> 1];
            }
            copy(arr.begin(),arr.end(),perm.begin());
        }
        return ans;
    }

    bool eq(vector<int> v1, vector<int> v2) {
        for (int i = 0; i < v1.size(); i++) {
            if (v1[i] != v2[i]) return false;
        }
        return true;
    }
};

int main() {
    (new Solution)->reinitializePermutation(4);
}
