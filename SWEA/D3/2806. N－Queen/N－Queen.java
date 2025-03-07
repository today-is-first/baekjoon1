import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N;
	static int[][] arr;
	static int[] dr = { -1, 1, -1, 1 };
	static int[] dc = { 1, 1, -1, -1 };
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			result = 0;
			for (int i = 0; i < N; i++) {
				search(0, i, 1);
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}

		System.out.println(sb);

	}

	static void search(int row, int col, int cnt) {
		if (arr[row][col] != 0)
			return;
		if (cnt == N) {
			result++;
			return;
		}
		check(row, col, cnt);
		for (int i = 0; i < N; i++) {
			search(row + 1, i, cnt + 1);
		}
		uncheck(cnt);
	}

	static void check(int row, int col, int target) {
		for (int n = 0; n < N; n++) {
			if (arr[row][n] == 0)
				arr[row][n] = target;
			if (arr[n][col] == 0)
				arr[n][col] = target;
			for (int i = 0; i < 4; i++) {
				int newRow = row + (dr[i] * n);
				int newCol = col + (dc[i] * n);
				if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N || arr[newRow][newCol] != 0)
					continue;
				arr[newRow][newCol] = target;
			}

		}
	}

	static void uncheck(int target) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == target)
					arr[i][j] = 0;
			}
		}
	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.err.println(sb);
	}

}