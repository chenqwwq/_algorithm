//
// Created by chenqwwq on 2023/3/6.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    int minimumDeletions(string s) {
        int n = (int) s.size();
        int ta = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') ta++;
        }
        int ans = ta, ac = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') ac++;
            // 计算0-i是b的数量和 i+1 - n 是a的数量
            ans = min(ans, i + 1 - ac + ta - ac);
        }
        return ans;
    }
};

int main(){
    (new Solution)->minimumDeletions("aababbab");
}