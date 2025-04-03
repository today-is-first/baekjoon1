import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[] amount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		amount = new int[10];
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int l = 0, r = 0, kind = 0, maxLen = 0;

		while (r < N) {
			if (amount[arr[r]] == 0)
				kind++;
			amount[arr[r]]++;
			r++;

			while (kind > 2) {
				amount[arr[l]]--;
				if (amount[arr[l]] == 0)
					kind--;
				l++;
			}
			maxLen = Math.max(maxLen, r - l);
		}

		System.out.println(maxLen);

	}

}
