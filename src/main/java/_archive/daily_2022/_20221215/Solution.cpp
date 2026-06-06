//
// Created by chenqwwq on 2022/12/15.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
private:
    int getNum(int num){
        int ret = 0;
        while (num){
            ret += num % 10;
            num /= 10;
        }
        return ret;
    }
public:
    int getLucky(string s, int k) {
        int num = 0;
        for (char c: s) {
            num += getNum (c - 'a' + 1);
        }

        while (k-- > 0){
            num = getNum(num);
        }
        return num;
    }
};