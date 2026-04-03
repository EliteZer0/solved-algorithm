#include <bits/stdc++.h>
using namespace std;

struct group {
    int boarding_time, arrival_time, member;
};
group group_list[100000];
bool is_boarded[100000];
int n, p, k;

void boarding(){
    // member 수별 대기열
    vector<queue<int>> wait(k + 1); 
    // 아직 wait에 안 넣은 다음 그룹 인덱스
    int ptr = 0;
    // 총 탑승 완료 그룹 수
    int boarded_cnt = 0;
    long long cur_boarding_time = 0;
    
    while(boarded_cnt < n){
        // 현재 출발 시각까지 도착한 그룹들을 대기열에 넣기
        while (ptr < n && group_list[ptr].arrival_time <= cur_boarding_time) {
            wait[group_list[ptr].member].push(ptr);
            ptr++;
        }

        // 현재 대기열에 아무도 없으면 다음 도착 그룹 기준으로 시간 점프
        bool has_wait = false;
        for (int i = 1; i <= k; i++) {
            if (!wait[i].empty()) {
                has_wait = true;
                break;
            }
        }

        if (!has_wait) {
            if (ptr < n) {
                long long next_arrival_time = group_list[ptr].arrival_time;
                if (cur_boarding_time < next_arrival_time) {
                    if (next_arrival_time % p == 0)
                        cur_boarding_time = next_arrival_time;
                    else
                        cur_boarding_time = next_arrival_time + (p - next_arrival_time % p);
                }
                continue;
            } else {
                break;
            }
        }

        int cur_boarded_member = 0;

        // 이번 회차에 태울 수 있을 때까지 반복
        while (true) {
            int remain = k - cur_boarded_member;
            int candidate = -1;

            // 남은 자리 이하인 그룹들 중 가장 먼저 도착한 그룹 선택
            for (int i = 1; i <= remain; i++) {
                if (wait[i].empty()) continue;

                int idx = wait[i].front();
                if (candidate == -1 ||
                    group_list[idx].arrival_time < group_list[candidate].arrival_time) {
                    candidate = idx;
                }
            }

            if (candidate == -1) break;

            int cur_member = group_list[candidate].member;
            wait[cur_member].pop();

            is_boarded[candidate] = true;
            group_list[candidate].boarding_time = cur_boarding_time;
            cur_boarded_member += cur_member;
            boarded_cnt++;
        }

        cur_boarding_time += p;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> n >> p >> k;

    for(int i = 0; i<n; i++){
        int t, a;
        cin >> t >> a;
        group_list[i] = {0, t, a};
    }

    // 도착시간 순으로 안 주더라고...
    // 정렬 필요함...
    sort(group_list, group_list + n, [](group a, group b){
        return a.arrival_time < b.arrival_time;
    });

    boarding();

    long long ans = 0;
    for(int i = 0; i<n; i++){
        ans += group_list[i].boarding_time - group_list[i].arrival_time;
    }
    cout << ans;
    return 0;
}