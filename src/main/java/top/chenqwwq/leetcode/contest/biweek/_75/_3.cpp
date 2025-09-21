//
// Created by 陈炳鑫 on 2022/4/2.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    long long numberOfWays(string s) {
        int n = s.length();
        long long a = 0, b = 0, c = 0;
        long long q = 0, w = 0, e = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '0') {
                c += b;
                a++;
                w += q;
            } else {
                e += w;
                q++;
                b += a;
            }
        }

        return c + e;
    }
};

int main() {
    (new Solution)->numberOfWays("0001100100");
}