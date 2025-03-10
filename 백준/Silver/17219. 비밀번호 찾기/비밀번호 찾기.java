import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = 1;
		Map<String, String> map = new HashMap<>();
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				map.put(st.nextToken(), st.nextToken());
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				sb.append(map.get(st.nextToken())).append('\n');
			}
		}
		System.out.println(sb);
	}
}