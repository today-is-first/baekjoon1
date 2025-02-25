import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}

		Arrays.sort(arr);
		
		int len = arr.length;
		if (N == 1 || arr[len - 1] - M > arr[len - 2]) {
			System.out.println(arr[len-1] - M);
			return;
		}
		
		int sum = 0;
		int result = 0;
		int max = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (arr[i] < result)
				break;
			int size = len - i;
			if (i == len - 1) {
				max = arr[i] - M;
				continue;
			}
			// 각 나무 높이의 차 구하기
			sum += (arr[i + 1] - arr[i]) * (size - 1);

			// 지금까지 합한게 M이랑 같은 경우
			if (sum == M) {
				result = Math.max(result, arr[i]);
			}

			// 지금까지 합한게 M보다 작은 경우
			if (sum < M) {
				result = Math.max(arr[i] - (int) Math.ceil((M - sum) / (double) size), result);
			}

		}

		System.out.println(result);

	}
}