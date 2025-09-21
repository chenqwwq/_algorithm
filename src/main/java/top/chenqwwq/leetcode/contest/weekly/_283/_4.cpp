//
// Created by 陈炳鑫 on 2022/3/6.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    vector<int> replaceNonCoprimes(vector<int>& a) {
        vector<int> s;
        for (int i = 0; i < a.size(); i++)
        {
            int x = a[i],gcd;
            while (s.size() > 0 && (gcd = __gcd(x, s[s.size() - 1])) > 1)
            {
                x = x / __gcd(x, s[s.size() - 1]) * s[s.size() - 1];
                s.pop_back();
            }
            s.push_back(x);
        }
        return s;
    }

};