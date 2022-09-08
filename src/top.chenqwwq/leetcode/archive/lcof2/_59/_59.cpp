//
// Created by chenqwwq on 2022/1/6.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class KthLargest {
public:
    priority_queue<int, vector<int>, greater<>> queue;
    int k;

    KthLargest(int k, vector<int> &nums) {
        this->k = k;
        for (int num: nums) {
            add(num);
        }
    }

    int add(int val) {
        queue.push(val);
        while (queue.size() > k) {
            queue.pop();
        }
        return queue.top();
    }
};