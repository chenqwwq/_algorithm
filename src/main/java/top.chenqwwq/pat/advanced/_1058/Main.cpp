//
// Created by 陈炳鑫 on 2022/5/4.
//


#include <iostream>
#include <sstream>

using namespace std;

int main() {
    string s1, s2, item;
    cin >> s1 >> s2;
    int n1[3], n2[3];
    stringstream ss(s1);
    for (int i = 0; getline(ss, item, '.'); ++i) {
        n1[i] = atoi(item.c_str());
    }
    stringstream sss(s2);
    for (int i = 0; getline(sss, item, '.'); ++i) {
        n2[i] = atoi(item.c_str());
    }

    int ans[3];
    int carry = (n1[2] + n2[2]) / 29;
    ans[2] = (n1[2] + n2[2]) % 29;
    ans[1] = (n1[1] + n2[1] + carry) % 17;
    carry = (n1[1] + n2[1] + carry) / 17;
    ans[0] = n1[0] + n2[0] + carry;
    printf("%d.%d.%d\n",ans[0],ans[1],ans[2]);
    return 0;
}