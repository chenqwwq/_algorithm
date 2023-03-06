//
// Created by 陈炳鑫 on 2022/4/3.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    char nextGreatestLetter(vector<char> &letters, char target) {
        int n = letters.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (letters[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return letters[l] < target ? letters[0] : letters[l];
    }
};