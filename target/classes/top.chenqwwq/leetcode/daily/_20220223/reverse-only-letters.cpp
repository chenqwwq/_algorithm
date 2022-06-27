//
// Created by 陈炳鑫 on 2022/2/23.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    string reverseOnlyLetters(string s) {
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            while (l < n && !isalpha(s[l])) l++;
            while (r >= 0 && !isalpha(s[r])) r--;
            if (l < n && r >= 0 && l < r) {
                char c = s[l];
                s[l] = s[r];
                s[r] = c;
            }
            l++;
            r--;
        }
        return s;
    }
};

int main(){
    (new Solution)->reverseOnlyLetters("?6C40E");
}