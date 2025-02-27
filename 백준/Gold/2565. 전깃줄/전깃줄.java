import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N];
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.add(new int[] { from, to });
		}

		list.sort((a, b) -> a[0] - b[0]);
		int max = 0;

		for (int k = 0; k < N; k++) {
			dp[k] = 1;
			for (int i = 0; i < k; i++) {
				if (list.get(i)[1] < list.get(k)[1]) {
					dp[k] = Math.max(dp[k], dp[i] + 1);
				}
			}
			max = Math.max(max, dp[k]);
		}

		System.out.println(N - max);
	}

}