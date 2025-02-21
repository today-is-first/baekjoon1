import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		memo = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		search(0, 0, 1);
		search(1, 0, 1);
		System.out.println(max);
	}

	static void search(int index, int sum, int seq) {
		if (index >= arr.length)
			return;
		sum += arr[index];
		if (index >= 2 && memo[index - 2] > sum)
			return;
		memo[index] = Math.max(memo[index], sum);
		if (index == arr.length - 1)
			max = Math.max(max, sum);
		// 바로 앞을 가거나
		if (seq < 2)
			search(index + 1, sum, seq + 1);
		// 점프해서 가거나
		search(index + 2, sum, 1);
	}
}