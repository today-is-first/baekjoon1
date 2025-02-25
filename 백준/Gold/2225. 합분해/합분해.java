import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[][] dp;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dp = new long[M + 1][N + 1];

		for (int i = 1; i <= M; i++) {
			for (int j = 0; j <= N; j++) {
				if (i == 1 || j == 0)
					dp[i][j] = 1;
				else
					dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1_000_000_000;
			}
		}

		System.out.println(dp[M][N] % 1_000_000_000);
	}
}