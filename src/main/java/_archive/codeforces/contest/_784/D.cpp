//
// Created by 陈炳鑫 on 2022/4/22.
//


#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int m;
    string str;
    while (n--) {
        cin >> m;
        cin >> str;
        bool flag = true;
        str += "W";
        int a = 0, b = 0;
        for (int i = 0; i <= m; ++i) {
            if (str[i] == 'W') {
                if ((a == 0 && b != 0) || (b == 0 && a != 0)) {
                    flag = false;
                    break;
                }
                a = 0;
                b = 0;
            } else if (str[i] == 'B') a++;
            else b++;
        }
        printf("%s\n", flag ? "YES" : "NO");
    }

    return 0;
}