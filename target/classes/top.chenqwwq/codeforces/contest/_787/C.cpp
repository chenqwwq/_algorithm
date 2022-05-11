//
// Created by 陈炳鑫 on 2022/5/6.
//


#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    while (n--) {
        string description;
        cin >> description;
        if (description.length() == 1) {
            printf("1\n");
            continue;
        }
        int m = (int) description.length();
        int a = 0, b = m - 1;
        for (int i = m - 1; i >= 0; --i) {
            if (description[i] == '1') {
                a = i;
                break;
            }
        }
        for (int i = 0; i < m; ++i) {
            if (description[i] == '0') {
                b = i;
                break;
            }
        }
        if (a > b) printf("1\n");
        else printf("%d\n", b - a + 1);
    }

    return 0;
}