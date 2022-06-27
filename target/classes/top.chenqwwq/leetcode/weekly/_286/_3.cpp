//
// Created by 陈炳鑫 on 2022/3/27.
//


#include "stdc++.h"
#include "common.h"

using namespace std;


typedef long long ll;

class Solution {
public:
    vector <ll> kthPalindrome(vector<int> &queries, int intLength) {
        auto m = queries.size();
        vector <ll> ans(m);
        for (int i = 0; i < m; ++i) {
            ans[i] = find(queries[i], intLength);
        }
        return ans;
    }
    ll find(int pos, int len) {
        if (pos <= 0 || pos > 9 * pow(10, (len - 1) / 2)) return -1LL;
        string ans(len, '0');
        ans[0] = '1';
        ans[len - 1] = '1';
        pos--;
        int cur = (len - 1) / 2;
        int level = len % 2 == 0 ? 1 : 0;
        while (pos > 0 && cur >= 0) {
            int num = pos % 10;
            char c = char((cur == 0 ? '1' : '0') + num);
            ans[cur] = c;
            ans[cur + level] = c;
            level += 2;
            cur -= 1;
            pos /= 10;
        }
        return stoll(ans);
    }
};