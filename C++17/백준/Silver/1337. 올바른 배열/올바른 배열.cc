#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int N;
    cin >> N;
    int arr[50];
    
    for(int i = 0; i<N; i++){
        cin >> arr[i];
    }

    sort(arr, arr+N);

    int left = 0;
    int right = 0;
    int ans = 4; // 최악의 경우 4개 추가 필요

    while(left<N){
        while(right<N && arr[right] - arr[left] <= 4) right ++;
        
        // 실제 원소 개수
        int cnt = right - left;
        ans = min(ans, 5-cnt);
        
        left++;
    }
    
    cout << ans;
    return 0;
}