//
// Created by 陈炳鑫 on 2022/4/30.
//


#include <iostream>
#include <vector>

using namespace std;

struct mouse {
    int wight, idx;


    mouse() {}

    mouse(int wight, int idx) : wight(wight), idx(idx) {}
};

int main() {
    int P, G;
    cin >> P >> G;
    vector<mouse *> ms(P, new mouse);
    for (int i = 0; i < P; ++i) cin >> ms[i]->wight;
    for (int i = 0; i < P; ++i) cin >> ms[i]->idx;

}