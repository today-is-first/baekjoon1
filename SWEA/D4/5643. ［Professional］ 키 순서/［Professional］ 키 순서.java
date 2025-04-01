import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private static int[] dp;
	private static boolean[][] arr;
	private static int N;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			arr = new boolean[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = true;
			}

			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (arr[i][k] && arr[k][j]) {
							arr[i][j] = true;
						}
					}
				}
			}

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				int tmp = 0;
				for (int j = 1; j <= N; j++) {
					if (i == j)
						continue;
					if (arr[i][j] || arr[j][i]) {
						tmp++;
					}
				}
				if (tmp == N - 1)
					cnt++;
			}

			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
