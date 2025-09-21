//
// Created by 陈炳鑫 on 2022/4/15.
//


#include <iostream>
#include <unordered_set>

using namespace std;

struct Node {
    int next;
    bool vis;

    Node() {}

    Node(int next, bool vis) : next(next), vis(vis) {}
} nodes[100000];

int main() {
    int a, b, c;
    scanf("%d %d %d", &a, &b, &c);
    int s, e;
    char ch;
    for (int i = 0; i < c; ++i) {
        scanf("%d %c %d", &s, &ch, &e);
        nodes[s] = Node{e, false};
    }
    while (a != -1) {
        nodes[a].vis = true;
        a = nodes[a].next;
    }

    while (b != -1) {
        if (nodes[b].vis) {
            printf("%05d\n", b);
            return 0;
        }
        b = nodes[b].next;
    }

    printf("%d\n", -1);
    return 0;
}