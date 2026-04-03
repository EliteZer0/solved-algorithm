import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[] students = new int[N * N];
		Map<Integer, boolean[]> preferences = new HashMap<>();

		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			students[i] = student;
			boolean[] prefs = new boolean[N * N + 1];
			for (int j = 0; j < 4; j++) {
				prefs[Integer.parseInt(st.nextToken())] = true;
			}
			preferences.put(student, prefs);
		}
        
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
		
        for (int student : students) {
			int maxLike = -1, maxEmpty = -1, bestX = -1, bestY = -1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > 0) continue;

					int likeCount = 0, emptyCount = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d], ny = j + dy[d];
						if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

						if (map[nx][ny] == 0) emptyCount++;
						else if (preferences.get(student)[map[nx][ny]]) likeCount++;
					}

					if (likeCount > maxLike || 
					   (likeCount == maxLike && emptyCount > maxEmpty) || 
					   (likeCount == maxLike && emptyCount == maxEmpty && (i < bestX || (i == bestX && j < bestY)))) {
						maxLike = likeCount;
						maxEmpty = emptyCount;
						bestX = i;
						bestY = j;
					}
				}
			}
			map[bestX][bestY] = student;
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int student = map[i][j];
				int likeCount = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d], ny = j + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if (preferences.get(student)[map[nx][ny]]) likeCount++;
				}
				if (likeCount > 0)
					sum += (int)Math.pow(10, likeCount - 1);
			}
		}
        
		System.out.println(sum);
	}

	
}