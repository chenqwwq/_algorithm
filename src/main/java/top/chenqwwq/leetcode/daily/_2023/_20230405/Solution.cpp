//
// Created by chenqwwq on 2023/4/5.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int commonFactors(int a, int b) {
        int cnt = 1;
        for(int i = 2;i <= min(a,b);i++){
            if(a % i == 0 && b % i == 0) cnt++;
        }
        return cnt;
    }
};