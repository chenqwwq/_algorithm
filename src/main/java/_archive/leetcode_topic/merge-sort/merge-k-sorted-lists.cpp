//
// Created by 陈炳鑫 on 2022/3/26.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        auto n = lists.size();
        ListNode *fake = new ListNode;
        ListNode *node = fake;
        auto compel = [&](pair<ListNode *, int> n1, pair<ListNode *, int> n2) -> bool {
            return n1.first->val > n2.first->val;
        };
        priority_queue<pair<ListNode *, int>, vector<pair<ListNode *, int>>, decltype(compel)> pq(compel);
        for (int i = 0; i < n; ++i) {
            if (!lists[i]) continue;
            pq.emplace(lists[i], i);
            lists[i] = lists[i]->next;
        }

        while (!pq.empty()) {
            auto top = pq.top();
            pq.pop();
            auto i = top.second;
            node->next = top.first;
            node = node->next;
            if (lists[i]) {
                pq.emplace(lists[i], i);
                lists[i] = lists[i]->next;
            }
        }
        return fake->next;
    }
};