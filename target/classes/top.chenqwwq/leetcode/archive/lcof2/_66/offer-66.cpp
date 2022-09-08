//
// Created by chenqwwq on 2022/1/19.
//

#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class MapSum {
private:
    map<char, MapSum *> child;
    char ch;
    int val;
public:
    /** Initialize your data structure here. */
    MapSum() {
        val = 0;
    }

    MapSum(char c) {
        ch = c;
        val = 0;
    }

    void insert(string key, int val) {
        MapSum *tmp = this;
        for (auto k: key) {
            if (tmp->child.find(k) == tmp->child.end()) {
                auto *p = new MapSum;
                p->ch = k;
                tmp->child[k] = p;
            }
            tmp = tmp->child[k];
        }
        tmp->val = val;
    }

    int sum(string prefix) {
        MapSum *tmp = this;
        for (auto k: prefix) {
            if (tmp->child.find(k) == tmp->child.end()) return 0;
            tmp = tmp->child[k];
        }
        return tmp->getTotal();
    }

    int getTotal() {
        cout << val << endl;
        int ans = val;
        for (auto&[key, value]: child) ans += value->getTotal();
        return ans;
    }
};


int main() {

}