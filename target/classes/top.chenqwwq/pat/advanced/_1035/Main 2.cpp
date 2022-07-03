//
// Created by 陈炳鑫 on 2022/4/18.
//


#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);
    vector<pair<string, string>> ans;
    string s1, s2;
    for (int i = 0; i < n; ++i) {
        cin >> s1 >> s2;
        bool flag = false;
        for (char &j: s2) {
            if (j == '1') {
                j = '@';
                flag = true;
            } else if (j == '0') {
                j = '%';
                flag = true;
            } else if (j == 'l') {
                j = 'L';
                flag = true;
            } else if (j == 'O') {
                j = 'o';
                flag = true;
            }
        }
        if (flag) ans.emplace_back(s1, s2);
    }
    if (ans.empty()) {
        printf("There %s %d %s and no account is modified\n", n == 1 ? "is" : "are", n,
               n == 1 ? "account" : "accounts");
        return 0;
    }
    printf("%d\n", (int) ans.size());
    for (auto &an: ans) {
        printf("%s %s\n", an.first.c_str(), an.second.c_str());
    }
    return 0;
}