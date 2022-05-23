//
// Created by chenqwwq on 2022/5/20.
//


#include <iostream>

using namespace std;

int main() {
    int t, num;
    scanf("%d", &t);
    while (t--) {
        scanf("%d", &num);
        if (num < 10) printf("%d\n", num);
        else if (num < 100) printf("%d\n", num % 10);
        else {
            int ans = 9;
            while (num) {
                ans = min(num % 10, ans);
                num /= 10;
            }
            printf("%d\n", ans);
        }
    }
    return 0;
}