//
// Created by chenqwwq on 2022/8/4.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;
    int nums[n];
    int a = -1, b = -1, c = -1;
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
        if (a == -1 || nums[i] < nums[a]) {
            c = b;
            b = a;
            a = i;
        } else if (nums[i] == nums[a]) {
            continue;
        } else if (b == -1 || nums[i] < nums[b]) {
            c = b;
            b = i;
        } else if(nums[i] == nums[b]){
            continue;
        }else if (c == -1 || nums[i] < nums[c]) {
            c = i;
        }
    }
    if (a == -1 || b == -1 || c == -1)cout << "-1 -1 -1" << endl;
    else cout << a + 1 << " " << b + 1 << " " << c + 1 << endl;
    return 0;
}