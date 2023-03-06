//
// Created by chenqwwq on 2023/1/7.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int countEven(int num) {
        int ans = 0;
        for (int i = 2; i <= num; i++) {
            ans += getSum(i) & 1 ^ 1;
        }
        return ans;
    }

    int getSum(int num) {
        int ret = 0;
        while (num) {
            ret += (num % 10);
            num /= 10;
        }
        return ret;
    }
};

int main(){
    (new Solution)->countEven(4);
}