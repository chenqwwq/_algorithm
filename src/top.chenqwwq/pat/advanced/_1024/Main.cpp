//
// Created by 陈炳鑫 on 2022/4/19.
//


#include <iostream>

using namespace std;


string reverse(string s) {
    string ans;
    for (int i = s.length() - 1; i >= 0; --i) ans += s[i];
    return ans;
}


string add(string s1, string s2) {
    int carry = 0;
    int i = (int) s1.length() - 1, j = (int) s2.length() - 1;
    string ans;
    while (i >= 0 && j >= 0) {
        int target = (s1[i--] - '0') + (s2[j--] - '0') + carry;
        ans = to_string(target % 10) + ans;
        carry = target / 10;
    }
    while (i >= 0) {
        int target = (s1[i--] - '0') + carry;
        ans = to_string(target % 10) + ans;
        carry = target / 10;
    }
    while (j >= 0) {
        int target = (s1[j--] - '0') + carry;
        ans = to_string(target % 10) + ans;
        carry = target / 10;
    }
    if (carry) ans = to_string(carry) + ans;
    return ans;
}

bool check(string s) {
    if (s.empty()) return true;
    for (int i = 0, j = (int) s.length() - 1; i < j; ++i, --j) {
        if (s[i] != s[j]) return false;
    }
    return true;
}

int main() {
    string s;
    int k;
    cin >> s;
    scanf("%d", &k);
    if (check(s)) {
        printf("%s\n", s.c_str());
        printf("0\n");
        return 0;
    }
    int i = 1;
    for (; i <= k; ++i) {
        s = add(s, reverse(s));
        if (check(s)) {
            printf("%s\n", s.c_str());
            printf("%d\n", i);
            return 0;
        }
    }
    printf("%s\n", s.c_str());
    printf("%d\n", k);
    return 0;
}