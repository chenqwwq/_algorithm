//
// Created by chenqwwq on 2022/8/28.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;
    string s;
    while (n--){
        cin >> s;
        int len = s.length();
        if(s.substr(len-2) == "po") cout << "FILIPINO" << endl;
        else if(s.substr(len-4) == "desu" || s.substr(len-4) == "masu") cout << "JAPANESE" << endl;
        else if(s.substr(len -5) == "mnida") cout << "KOREAN" << endl;
    }
    return 0;
}