import java.util.*;
import java.io.*;

public class Main {
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<M; i++){
            int input = Integer.parseInt(st.nextToken());
			if(binarySearch(input) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
    }

    public static int binarySearch(int key) {
 
		int lo = 0;
		int hi = nums.length - 1;
        
		while(lo <= hi) {
 
			int mid = (lo + hi) / 2;
 
			if(key < nums[mid]) {
				hi = mid - 1;
			}
			else if(key > nums[mid]) {
				lo = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
}