//
// Created by chenqwwq on 2022/5/28.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

int main() {
    string num;
    cin >> num;
    for (int i = 0; i < num.length(); ++i) {
        int t = num[i] - '0';
        int curr = min(t,9- t);
        printf("%d",i == 0 && curr == 0 ? t : curr);
    }
    printf("\n");
    return 0;
}