//
// Created by 陈炳鑫 on 2022/3/1.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    string convert(string s, int m) {
        if(m == 1) return s;
        string ans;
        int n = s.length(), x = 2 * m - 2;
        for (int i = 0; i < n / x + 1; ++i) {
            int pos = i;
            while (pos < n){
                ans += s[pos];
                pos += x;
            }
            // PINALSIGYAHRPI

        }
        return ans;
    }

//    string convert(string s, int m) {
//        if(m == 1) return s;
//        int n = s.length();
//        vector<vector<char>> ans(m, vector<char>(n, ' '));
//        int i = 0, j = 0, pos = 0;
//        while (pos < n) {
//            while (pos < n && i < m){
//                ans[i++][j] = s[pos++];
//            }
//            i--;
//            while (pos < n && i > 0) {
//                ans[--i][++j] = s[pos++];
//            }
//            i++;
//        }
//        string str;
//        for (int q = 0; q < m; ++q) {
//            for (int p = 0; p < n; ++p) {
//                if (ans[q][p] != ' ') str += ans[q][p];
//            }
//        }
//        return str;
//    }
};

int main() {
    (new Solution)->convert("PAYPALISHIRING", 4);
    // PAHNAPLSIIGYIR
    // PINALSIGYAHRPI
    // 0     6   12
    // P     I    N
    // 1   5 7  11 13
    // A   L S  I G
    // 2 4   8 10
    // Y A   H R
    // 3     9
    // P     I
}