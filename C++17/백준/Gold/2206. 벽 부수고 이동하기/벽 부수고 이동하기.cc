#include <iostream>
#include <queue>
#include <vector>
using namespace std;

static int n, m;

struct dist {
	int r;
	int c;
	bool wall;
	int d;

	dist(int a, int b, bool w, int di) : r(a), c(b), wall(w), d(di) {};
};

int bfs(char map[1000][1000], bool visited[1000][1000][2]) {
	queue<dist> q;
	int dr[4] = {1, -1, 0, 0};
	int dc[4] = {0, 0, 1, -1};
	q.push(dist(0, 0, true, 1));
    visited[0][0][1] = true;

	while (!q.empty()) {
		dist d = q.front();
		int r = d.r;
		int c = d.c;
		int distance = d.d;
		bool wall = d.wall;
		q.pop();
        
		if (r == n - 1 && c == m - 1)
			return distance;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
				if (!visited[nr][nc][wall]) {
					if (map[nr][nc] == '0') {
						visited[nr][nc][wall] = true;
						q.push(dist(nr, nc, wall, distance + 1));
					} else if (wall) {
						visited[nr][nc][wall] = true;
						q.push(dist(nr, nc, false, distance + 1));
					}
				}
			}
		}
	}
	return -1;
};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> m;
	char map[1000][1000];
	bool visited[1000][1000][2];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j<m; j++)
			cin >> map[i][j];
	}

	cout << bfs(map, visited);

	return 0;
}