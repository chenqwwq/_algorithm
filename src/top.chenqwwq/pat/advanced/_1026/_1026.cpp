//
// Created by 陈炳鑫 on 2022/1/7.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

struct person {
    int arrive, time;
    bool vip;
} per;

struct table {
    int num, end = -1, service_cnt;
    bool vip;
} tab;

int N, K, M; // 用户数,桌子数,vip桌子数
vector<person> players; // 用户列表
vector<table> tables; // 桌子列表,桌子的数量只有100个,就不用优先级队列了

int findTable(person *p) {
    for (int i = 0; i < K; ++i) {
        if (p->arrive >= tables[i].end) {
            return i;
        }
    }
    return -1;
}

int main() {
    const int start = 8 * 3600, end = 31 * 3600, max = 2 * 60;
    scanf("%d", &N);
    int hour, minu, second, time, vvip;
    for (int i = 0; i < N; ++i) {
        scanf("%d:%d:%d %d %d", &hour, &minu, &second, &time, &vvip);
        if (hour >= 21) {
            continue;
        }
        per.arrive = 3600 * hour + 60 * minu + second;
        per.vip = vvip;
        per.time = time > 120 ? 7200 : time * 60;
        players.push_back(per);
    }
    scanf("%d\n%d", &K, &M);
    tables.resize(M + 1);
    int pos;
    for (int i = 0; i < M; ++i) {
        scanf("%d", &pos);
        tables[pos].vip = true;
    }

    // 根据到达的时间排序
    sort(players.begin(), players.end(), [&](const person p1, person p2) {
        return p1.arrive < p2.arrive;
    });

    // 根据用户到达的时间维护一个唯一的增量时间戳
    // 用户到达的时间都不一样
    int i = 0;
    int using_table_cnt = 0;
    while (i < N) {
        person &person = players[i];
        int table = findTable(&person);
        if(table == -1){

        }
    }

}

