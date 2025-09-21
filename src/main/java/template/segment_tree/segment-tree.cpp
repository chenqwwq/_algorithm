//
// Created by chenqwwq on 2022/6/2.
//


#include "bits/stdc++.h"
#include "common.h"

#define lc k << 1;
#define rc k << 1 | 1;

const int maxn = 1e4 + 5;
const int inf = 0x3f3f3f3f;

using namespace std;

struct node {
    int l, r, mx;
} tree[maxn << 2]; // 四倍空间

void build(int k, int l, int r) {
    tree[k].l = l;
    tree[k].r = r;
    if (l == r){
        return;
    }
}