//
// Created by 陈炳鑫 on 2022/3/19.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    long long maximumSubsequenceCount(string text, string pattern) {
        char c1 = pattern[0], c2 = pattern[1];
        long long a = 0, b = 0;
        long long ans = 0;
        for (char c: text) {
            if (c == c1) {
                if (c1 == c2) ans += a;
                a++;
            } else if (c == c2) {
                b++;
                ans += a;
            }
        }
        return ans + (a > b ? a : b);
    }
};

int main() {
    (new Solution)->maximumSubsequenceCount("fwymvreuftzgrcrxczjacqovduqaiig",
                                            "yy");
}