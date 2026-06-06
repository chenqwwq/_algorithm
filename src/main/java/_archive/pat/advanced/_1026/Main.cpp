//
// Created by 陈炳鑫 on 2022/4/19.
//


#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <unordered_set>
#include <functional>


struct Customer {
    int arrival, playing;
    bool vip;

    Customer() {}

    Customer(int arrival, int playing, bool vip) : arrival(arrival), playing(playing), vip(vip) {}
};

using namespace std;

// 1~N 一共 N 张桌子
// 每次到使用 Id 最小的桌子，所有桌子都满了就排队
// 每队最多玩两个小时（120分钟）
bool cmp(Customer *c1, Customer *c2) {
    return c1->arrival < c2->arrival;
}


string toString(int time) {
    string ans = to_string(time);
    return ans.length() == 1 ? "0" + ans : ans;
}

string tran2time(int time) {
    return toString(time / 3600) + ":" + toString(time % 3600 / 60) + ":" + toString(time % 60);
}


int main() {
    int n;
    scanf("%d", &n);
    vector<Customer *> vcs(n);
    int h, m, s, p, v;
    for (int i = 0; i < n; ++i) {
        scanf("%d:%d:%d %d %d", &h, &m, &s, &p, &v);
        vcs[i] = new Customer(h * 3600 + m * 60 + s, p, v == 1);
    }
    int tn, vn;
    scanf("%d %d", &tn, &vn);
    int num;
    unordered_set<int> vvt;
    for (int i = 0; i < vn; ++i) {
        scanf("%d", &num);
        vvt.insert(num - 1);
    }
    priority_queue<int, vector<int>, greater<>> t, vt;
    for (int i = 0; i < tn; ++i) {
        if (vvt.count(i)) vt.push(i);
        else t.push(i);
    }

    // 记录每张桌子的使用数
    vector<int> tab(tn);
    // 记录最终答案
    vector<vector<string>> ans;
    // 使用中的桌子，<结束时间，桌子Id>
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> use;
    // 等待队列，正常队列和vip队列
    deque<int> q, vq;

    // 出队列并且使用一张桌子
    auto handle = [&](int cv, pair<int, int> cur) {
        string ar = tran2time(vcs[cv]->arrival), st = tran2time(cur.first), wt = to_string(
                (cur.first - vcs[cv]->arrival + 30) / 60);
        ans.push_back({ar, st, wt});
        use.push(make_pair(cur.first + min(2 * 3600, vcs[cv]->playing * 60), cur.second));
        tab[cur.second]++;
    };
    auto handleQ = [&](deque<int> &q, pair<int, int> cur) {
        int cv = q.front();
        q.pop_front();
        handle(cv, cur);
    };
    auto handlePq = [&](int cv, priority_queue<int, vector<int>, greater<>> &t, int time) {
        int ch = t.top();
        t.pop();
        handle(cv, make_pair(time, ch));
    };

    // 先排序
    sort(vcs.begin(), vcs.end(), cmp);
    for (int i = 0; i < n; ++i) {
        Customer *c = vcs[i];
        if(c->arrival >= 21 * 3600) break;
        int time = c->arrival;
        while (!use.empty() && time > use.top().first) {
            auto cur = use.top();
            use.pop();
            if (vvt.count(cur.second)) {
                if (!vq.empty() || !q.empty()) {
                    if (!vq.empty()) handleQ(vq, cur);
                    else if (!q.empty()) handleQ(q, cur);
                    continue;
                }
            } else if (!q.empty() || !vq.empty()) {
                if (q.empty()) handleQ(vq, cur);
                else if (vq.empty()) handleQ(q, cur);
                else if (q.front() < vq.front()) handleQ(q, cur);
                else handleQ(vq, cur);
                continue;
            }
            t.push(cur.second);
        }

        if (c->vip && !vt.empty()) handlePq(i, vt, time);
        else if (!t.empty() && !vt.empty()) {
            if (t.top() < vt.top()) handlePq(i, t, time);
            else handlePq(i, vt, time);
        } else if (!t.empty()) handlePq(i, t, time);
        else if (!vt.empty()) handlePq(i, vt, time);
        else if (c->vip) vq.push_back(i);
        else q.push_back(i);
    }
    while ((!vq.empty() || !q.empty()) && !use.empty() && 21 * 3600 > use.top().first) {
        auto cur = use.top();
        use.pop();
        if (vvt.count(cur.second)) {
            if (!vq.empty()) handleQ(vq, cur);
            else if (!q.empty()) handleQ(q, cur);
        } else if (q.empty()) handleQ(vq, cur);
        else if (vq.empty()) handleQ(q, cur);
        else if (q.front() < vq.front()) handleQ(q, cur);
        else handleQ(vq, cur);
    }

    for (auto a: ans) {
        printf("%s %s %s\n", a[0].c_str(), a[1].c_str(), a[2].c_str());
    }
    printf("%d", tab[0]);
    for (int i = 1; i < tn; ++i) printf(" %d", tab[i]);
    cout << endl;
    return 0;
}