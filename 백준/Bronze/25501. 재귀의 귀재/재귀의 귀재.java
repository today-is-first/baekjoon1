import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String s = br.readLine();

			dfs(s, 1, 0, s.length()-1);
		}
	}

	private static void dfs(String s, int depth, int start, int end) {
		if (start >= end) {
			System.out.printf("%d %d\n", 1, depth);
			return;
		}
		if (s.charAt(start) != s.charAt(end)) {
			System.out.printf("%d %d\n", 0, depth);
			return;
		}
		dfs(s, depth+1, start+1, end-1);
	}
}