//
// Created by chenqwwq on 2022/1/6.
//

#include "bits/stdc++.h"

using namespace std;

const int N = 1e6 + 10;

const void dfs(vector<int> &a, vector<int> *b) {
    a.push_back(1);
    b->push_back(2);
}


int main() {
    //给定int a;，则&a为您提供a的地址，即int *。在给定int *p;的情况下，表达式*p为您提供int指向的p。因此，*(&a)是a地址后面的值，即a。换句话说，*(&a)的作用与a相同。
    vector<int> a{};
    vector<int> v{};
    dfs(a, &v);
    cout << a[0] << endl;
    cout << v[0] << endl;
}
