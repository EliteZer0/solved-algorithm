#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int N, L;
    cin >> N >> L;
    
    deque<pair<int, int>> dq;

    for (int i = 0; i < N; i++) {
        int x;
        cin >> x;

        while (!dq.empty() && dq.back().first > x) {
            dq.pop_back();
        }

        dq.push_back({x, i});

        while (!dq.empty() && dq.front().second < i - L + 1) {
            dq.pop_front();
        }

        cout << dq.front().first << " ";
    }
    return 0;
}