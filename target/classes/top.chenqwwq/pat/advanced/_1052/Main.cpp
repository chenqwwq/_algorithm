//
// Created by 陈炳鑫 on 2022/4/26.
//


#include <iostream>
#include <algorithm>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    int N;
    string h;
    cin >> N >> h;
    unordered_map<string, pair<int, string>> graph;
    string add, next;
    int val;
    for (int i = 0; i < N; ++i) {
        cin >> add >> val >> next;
        graph[add] = make_pair(val, next);
    }
    vector<pair<int, string>> vs;
    while (h != "-1" && graph.find(h) != graph.end()) {
        vs.emplace_back(graph[h].first, h);
        h = graph[h].second;
    }
    const auto cnt = (int) vs.size();
    if(!cnt){
        printf("%d %s\n", 0, "-1");
        return 0;
    }
    sort(vs.begin(), vs.end());
    printf("%d %s\n", cnt, vs[0].second.c_str());
    for (int i = 0; i < cnt; ++i) {
        printf("%s %d %s\n",vs[i].second.c_str(),vs[i].first,i + 1 < cnt ? vs[i+1].second.c_str() : "-1");
    }
    return 0;
}