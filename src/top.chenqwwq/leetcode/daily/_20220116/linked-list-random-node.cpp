//
// Created by 陈炳鑫 on 2022/1/16.
//

#include "stdc++.h"
#include "common.h"

using namespace std;


class Solution {

private:
    ListNode *head;
public:
    Solution(ListNode *head) {
        this->head = head;
    }

    int getRandom() {
        int i = 1, ans = 0;
        for (ListNode *node = head; node != nullptr; node = node->next) {
            if (rand() % i++ == 0) {
                ans = node->val;
            }
        }
        return ans;
    }
};

int main() {
    cout << 4 % 1 << endl;
}