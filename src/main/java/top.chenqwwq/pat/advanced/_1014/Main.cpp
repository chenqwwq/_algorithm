//
// Created by 陈炳鑫 on 2022/4/21.
//


#include <iostream>
#include <queue>
#include <deque>

using namespace std;

struct work {
    int finish, win, id;

    work() {}

    work(int finish, int win, int id) : finish(finish), win(win), id(id) {}
};

string tran2Time(int miu) {
    string h = to_string(8 + (miu / 60)), m = to_string(miu % 60);
    return (h.length() == 1 ? "0" + h : h) + ":" + (m.length() == 1 ? "0" + m : m);
}

int main() {
    // the number of windows
    // the maximum capacity of each line inside the yellow line
    // number of customers
    // number of customer queries
    int N, M, K, Q;
    scanf("%d %d %d %d", &N, &M, &K, &Q);
    int pt[K];
    for (int i = 0; i < K; ++i) scanf("%d", &pt[i]);
    int queries[Q];
    for (int i = 0; i < Q; ++i) scanf("%d", &queries[i]);
    if (Q <= 0) return 0;

    auto cmp = [](work w1, work w2) {
        if (w1.finish == w2.finish) return w1.win > w2.win;
        return w1.finish > w2.finish;
    };

    vector<int> ans(K, -1);
    priority_queue<work, vector<work>, decltype(cmp)> handing(cmp);
    vector<deque<int>> waiting(N, deque<int>());
    int id = 0;
    for (int j = 0; j < N; ++j) {
        if (id >= K) break;
        handing.push(work(pt[id], j, id));
        id++;
    }
    for (int i = 1; i < M; ++i) {
        for (int j = 0; j < N; ++j) {
            if (id >= K) break;
            waiting[j].push_back(id++);
        }
    }
    while (!handing.empty()) {
        // 结束任务
        auto w = handing.top();
        handing.pop();
        ans[w.id] = w.finish;
        // 超过下午五点不接待了
        if (w.finish >= 9 * 60) continue;
        // 黄线内等待队列弹出
        // 总的等待队列弹出
        if (id < K) {
            waiting[w.win].push_back(id++);
        }
        if (!waiting[w.win].empty()) {
            int i = waiting[w.win].front();
            waiting[w.win].pop_front();
            handing.push(work(w.finish + pt[i], w.win, i));
        }
    }
    for (auto q: queries) {
        if (ans[q - 1] == -1) printf("Sorry\n");
        else printf("%s\n", tran2Time(ans[q - 1]).c_str());
    }
    return 0;
}