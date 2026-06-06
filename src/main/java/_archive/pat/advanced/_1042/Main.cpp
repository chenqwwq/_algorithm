//
// Created by 陈炳鑫 on 2022/4/19.
//


#include <iostream>

using namespace std;


int main() {
    int n;
    scanf("%d", &n);
    int pos[54];
    for (int &po: pos) scanf("%d", &po);
    string origin[54];
    int p = 0;
    for (string pre: {"S", "H", "C", "D"}) {
        for (int i = 1; i <= 13; ++i) {
            origin[p++] = pre + to_string(i);
        }
    }
    origin[52] = "J1";
    origin[53] = "J2";

    string des[54];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < 54; ++j) {
            des[pos[j] - 1] = origin[j];
        }
        copy(begin(des), end(des), begin(origin));
    }
    printf("%s", origin[0].c_str());
    for (int i = 1; i < 54; ++i) printf(" %s", origin[i].c_str());
    cout << endl;
    return 0;
}