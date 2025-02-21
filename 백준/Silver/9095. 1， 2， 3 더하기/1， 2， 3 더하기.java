import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count = 0;
	static int target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= N; tc++) {
			count = 0;
			target = Integer.parseInt(br.readLine());
			search(0, 0, 0, 0);
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	static void search(int num, int coin1, int coin2, int coin3) {
		int sum = coin1 * 1 + coin2 * 2 + coin3 * 3;
		if (sum > target)
			return;
		if (target == sum) {
			count++;
		}
		search(sum, coin1 + 1, coin2, coin3);
		search(sum, coin1, coin2 + 1, coin3);
		search(sum, coin1, coin2, coin3 + 1);
	}
}