#include <bits/stdc++.h>
using namespace std;

int toSec(const string& str) {
    int h = (str[0] - '0') * 10 + (str[1] - '0');
    int m = (str[3] - '0') * 10 + (str[4] - '0');
    int s = (str[6] - '0') * 10 + (str[7] - '0');
    return h * 3600 + m * 60 + s;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    const int T = 86400;

    int n;
    cin >> n;
    
    vector<long long> diff(T + 1, 0);
    int len = 0;

    for (int i = 0; i < n; i++) {
        int cmd;
        cin >> cmd;

        if (cmd == 1) {
            string start, end;
            cin >> start >> end;

            int s = toSec(start);
            int e = toSec(end);

            // 시작점 1
            diff[s] += 1;
            // 끝나는 점 미포함이니까 -1
            diff[e] -= 1;
        } else {
            string time;
            cin >> time;
            len = toSec(time);
        }
    }

    // 각 1초 구간의 실제 값
    vector<long long> val(T, 0);
    val[0] = diff[0];
    for (int i = 1; i < T; i++) {
        val[i] = val[i - 1] + diff[i];
    }

    // 누적합
    vector<long long> prefix(T + 1, 0);
    for (int i = 0; i < T; i++) {
        prefix[i + 1] = prefix[i] + val[i];
    }

    long long ans = 0;
    for (int i = len; i< T; i++) {
        ans = max(ans, prefix[i] - prefix[i-len]);
    }
    
    cout << ans;
    return 0;
}