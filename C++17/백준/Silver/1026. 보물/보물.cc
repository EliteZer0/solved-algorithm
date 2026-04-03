#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    // A 정렬 : 0 1 1 1 6
    // B 정렬 : 1 2 3 7 8
    // A 작은거 B 큰거 순 곱 : 0 7 3 2 6

    int N, A[50], B[50];

    cin >> N;

    for(int i = 0; i<N; i++){
        cin >> A[i];
    }

    sort(A, A+N);
    
    for(int i = 0; i<N; i++){
        cin >> B[i];
    }

    sort(B, B+N);

    int ans = 0;

    for(int i = 0; i<N; i++){
        ans += A[i] * B[N-i-1];
    }

    cout << ans;
    return 0;
}