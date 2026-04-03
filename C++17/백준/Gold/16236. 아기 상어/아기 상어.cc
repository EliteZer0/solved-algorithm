#include <bits/stdc++.h>
using namespace std;

struct Shark {
    int r, c;
    int size;
    int eat;
};

int n;
int board[20][20];
Shark shark_info;

int dr[4] = {-1, 0, 0, 1}; // 상, 좌, 우, 하
int dc[4] = {0, -1, 1, 0};

bool check(int r, int c) {
    return r >= 0 && r < n && c >= 0 && c < n;
}

int bfs() {
    bool visited[20][20] = {false};
    queue<tuple<int, int, int>> q; // r, c, dist

    q.push({shark_info.r, shark_info.c, 0});
    visited[shark_info.r][shark_info.c] = true;

    int bestDist = INT_MAX;
    int bestR = -1;
    int bestC = -1;

    while (!q.empty()) {
        auto [r, c, dist] = q.front();
        q.pop();

        if (dist > bestDist) continue;

        if (board[r][c] > 0 && board[r][c] < shark_info.size) {
            if (dist < bestDist) {
                bestDist = dist;
                bestR = r;
                bestC = c;
            } else if (dist == bestDist) {
                if (r < bestR || (r == bestR && c < bestC)) {
                    bestR = r;
                    bestC = c;
                }
            }
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!check(nr, nc)) continue;
            if (visited[nr][nc]) continue;
            if (board[nr][nc] > shark_info.size) continue;

            visited[nr][nc] = true;
            q.push({nr, nc, dist + 1});
        }
    }

    if (bestR == -1) return 0;

    shark_info.r = bestR;
    shark_info.c = bestC;
    shark_info.eat++;
    board[bestR][bestC] = 0;

    if (shark_info.eat == shark_info.size) {
        shark_info.size++;
        shark_info.eat = 0;
    }

    return bestDist;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> board[i][j];
            if (board[i][j] == 9) {
                shark_info = {i, j, 2, 0};
                board[i][j] = 0;
            }
        }
    }

    int answer = 0;
    while (true) {
        int dist = bfs();
        if (dist == 0) break;
        answer += dist;
    }

    cout << answer;
    return 0;
}