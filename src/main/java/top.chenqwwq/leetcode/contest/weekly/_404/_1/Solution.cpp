//
// Created by chenqwwq on 2024/6/30.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int maxHeightOfTriangle(int red, int blue) {
        return max(h(red,blue),h(blue,red));
    }

    int h(int red, int blue) {
        int cur = 1, ans = 0;
        bool flag = true;
        while ((flag && red >= cur) || (!flag && blue >= cur)) {
            if (flag) red -= cur;
            else blue -= cur;
            flag = !flag;
            cur++;
            ans++;
        }
        return ans;
    }
};