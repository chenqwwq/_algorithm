//
// Created by 陈炳鑫 on 2022/2/25.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
    const char *add = "+";
public:
    string complexNumberMultiply(string num1, string num2) {
        // a1+b1*i
        // a2+b2*i
        int s1 = num1.find(add), s2 = num2.find(add);

        int a1 = stoi(num1.substr(0, s1)), b1 = stoi(num1.substr(s1 + 1, num1.size() - 1)),
                a2 = stoi(num2.substr(0, s2)), b2 = stoi(num2.substr(s2 + 1, num2.size() - 1));

        int a = a1 * a2 - b1 * b2, b = a1 * b2 + a2 * b1;

        return to_string(a) + add + to_string(b) + "i";
    }
};