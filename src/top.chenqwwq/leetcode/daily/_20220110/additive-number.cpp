//
// Created by chenqwwq on 2022/1/10.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int n;
    vector<string> nums;

    bool isAdditiveNumber(string num) {
        n = num.length();
        return n < 3 ? false : backtrace(num, 0);
    }

    bool backtrace(string num, int p) {
        int size = nums.size();
        if (p >= n) return size >= 3;
        int max = num[p] == '0' ? p + 1 : n;
        string target;
        for (int i = p; i < max; ++i) {
            target += num[i];
            if (size < 2 || check(nums[size - 1], nums[size - 2], target)) {
                nums.push_back(target);
                if (backtrace(num, i + 1)) return true;
                nums.pop_back();
            }
        }
        return false;
    }

    bool check(const string &n1, const string &n2, const string &n3) {
        return n3 == add(n1, n2);
    }

    // 大数加法模板
    string add(const string &a, const string &b) {
        int n1 = a.size() - 1;
        int n2 = b.size() - 1;
        int carry = 0;
        string ans;

        while (n1 >= 0 || n2 >= 0 || carry > 0) {
            int t1 = n1 >= 0 ? a[n1--] - '0' : 0;
            int t2 = n2 >= 0 ? b[n2--] - '0' : 0;
            ans += (t1 + t2 + carry) % 10 + '0';
            carry = (t1 + t2 + carry) / 10;
        }

        reverse(ans.begin(), ans.end());
        return ans;
    }
};