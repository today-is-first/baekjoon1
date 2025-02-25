import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static Set<Integer> set;
	static Map<Integer, List<Integer>> map;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		if (M == 0) {
			System.out.println(N);
			return;
		}

		map = new HashMap<>();
		set = new HashSet<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (!map.containsKey(from))
				map.put(from, new ArrayList<Integer>());
			if (!map.containsKey(to))
				map.put(to, new ArrayList<Integer>());
			map.get(from).add(to);
			map.get(to).add(from);
		}

		map.keySet().forEach(k -> search(k));
		System.out.println(cnt + N - map.keySet().size());
	}

	static void search(int index) {
		if (!set.contains(index)) {
			cnt++;
		}
		set.add(index);
		for (int n : map.get(index)) {
			if (!set.contains(n)) {
				set.add(n);
				search(n);
			}
		}
	}
}