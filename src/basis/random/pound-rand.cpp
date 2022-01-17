//
// Created by 陈炳鑫 on 2022/1/16.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

// 蓄水池抽样算法
// 蓄水池抽样算法是对一个大型数据或者流数据等概率抽样等算法
// 每个数据样本被抽取的概率是 1 / n,简单计算如下:
// (1 / i) * (1 - (1 / i + 1) .... (1 - (1 - (1 / n));
// === > (1 / i) * (i / (i + 1)) * ((i + 1) / (i + 2))
// === > 1 / n
// 第i个值，整除为0概率均等，直接作为1) *

struct Node {
    int val;
    Node *next;
};

int getRandom(Node *node) {
    int i = 1, ans = 0;
    for (; node != nullptr; node = node->next) {
        if (rand() % i++ == 0) {
            ans = node->val;
        }
    }
    return ans;
}