//
// Created by 陈炳鑫 on 2022/3/13.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {

public:
    int mask = 0b11000000;

    bool validUtf8(vector<int> &data) {
        auto n = data.size();
        for (int i = 0; i < n; ++i) {
            int cnt = getCnt(data[i]);
            if (cnt == 0) continue;
            if (cnt > 4 || cnt < 2) return false;
            while (--cnt > 0) if (++i >= n || (data[i] & mask) != 0b10000000) return false;
        }
        return true;
    }

    int getCnt(int data) {
        int cnt = 0, base = 0b10000000;
        while (data & base) {
            cnt++;
            base >>= 1;
        }
        return cnt;
    }
};

int main() {
    vector<int> v1{145};
    (new Solution)->validUtf8(v1);
}