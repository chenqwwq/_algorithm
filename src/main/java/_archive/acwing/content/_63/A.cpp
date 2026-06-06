//
// Created by chenqwwq on 2022/8/8.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int a,b,n;
    cin >> a >> b >> n;
    int ans = 0;
    for(int i = 0;i <= a;i++){
        for(int j = 0;j <= b;j++){
            if(i + j == n) ans ++;
        }
    }
    cout << ans << endl;
    return 0;
}