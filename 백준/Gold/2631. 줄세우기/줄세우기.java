import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int max = 0;
		int cnt = 0;

		for (int k = 0; k < N; k++) {
			dp[k] = 1;
			for (int i = 0; i < k; i++) {
				if (arr[i] < arr[k]) {
					dp[k] = Math.max(dp[k], dp[i] + 1);
				}
			}
			max = Math.max(max, dp[k]);
		}

		System.out.println(N-max);
	}

}