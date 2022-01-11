//
// Created by 陈炳鑫 on 2022/1/6.
//

#include "stdc++.h"

using namespace std;

const int N = 1e6 + 10;

int main() {
    //给定int a;，则&a为您提供a的地址，即int *。在给定int *p;的情况下，表达式*p为您提供int指向的p。因此，*(&a)是a地址后面的值，即a。换句话说，*(&a)的作用与a相同。
    int a = 0;
    int *b = &a;
    // 定义一个引用直接指向a,
    int &c = a;
    int d = a;
    printf("%d\n", *b);
    printf("%d\n", b);
    printf("%d\n", &c);
    printf("%d\n", c);
    printf("%d\n", *(&c));
    printf("%d\n", &d);
    printf("%d\n", d);
    printf("%d\n", *(&d));
}