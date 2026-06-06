//
// Created by 陈炳鑫 on 2022/4/14.
//


#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, m;
    scanf("%d", &n);
    vector<int> n1(n);
    for (int i = 0; i < n; ++i) scanf("%d", &n1[i]);
    scanf("%d", &m);
    vector<int> n2(m);
    for (int i = 0; i < m; ++i) scanf("%d", &n2[i]);

    if (!m) return n1[(n - 1) >> 1];
    if (!n) return n2[(m - 1) >> 1];

    int mid = (n + m - 1) >> 1;
    int i = 0, j = 0;
    while (mid--) {
        if (i >= n) j++;
        else if (j >= m) i++;
        else if (n1[i] < n2[j]) i++;
        else j++;
    }
    if (i >= n) printf("%d\n", n2[j]);
    else if (j >= m) printf("%d\n", n1[i]);
    else printf("%d\n", n1[i] > n2[j] ? n2[j] : n1[i]);

    return 0;
}