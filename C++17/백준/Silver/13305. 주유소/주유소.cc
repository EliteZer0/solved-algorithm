#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<long long> highway(N - 1);
    for (int i = 0; i < N - 1; i++) {
        cin >> highway[i];
    }

    vector<long long> cost(N);
    for (int i = 0; i < N; i++) {
        cin >> cost[i];
    }

    // 내 뒤에 있는 도시에서
    // 나보다 작은 값이 나오면
    // 거기까지 갈 수 있는 양만큼 주유
    long long ans = 0;
    long long minCost = cost[0];

    for (int i = 0; i < N - 1; i++) {
        minCost = min(minCost, cost[i]);
        ans += minCost * highway[i];
    }

    cout << ans;
    return 0;
}