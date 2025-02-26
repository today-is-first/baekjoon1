import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		long max = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			max = Math.max(max, num);
		}

		long mid = 0;
		long left = 1;
		long right = max;
		long result = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			long amount = getAmount(mid);
			if (amount >= M) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(result);
	}

	static long getAmount(long num) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i] / num;
		}
		return sum;
	}

}