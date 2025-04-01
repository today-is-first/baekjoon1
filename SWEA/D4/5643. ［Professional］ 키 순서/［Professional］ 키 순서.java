import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	private static int N;
	private static boolean[][] arr; // 자신보다 큰 학생 (정방향)
	private static boolean[][] arr2; // 자신보다 작은 학생 (역방향)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			arr = new boolean[N + 1][N + 1];
			arr2 = new boolean[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = true;
				arr2[to][from] = true;
			}

			Map<Integer, Set<Integer>> greater = new HashMap<>();
			Map<Integer, Set<Integer>> smaller = new HashMap<>();

			for (int i = 1; i <= N; i++) {
				search(i, arr, greater);
				search(i, arr2, smaller);
			}

			int count = 0;
			for (int i = 1; i <= N; i++) {
				int total = greater.get(i).size() + smaller.get(i).size();
				if (total == N - 1) {
					count++;
				}
			}

			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}

		System.out.print(sb);
	}

	// DFS로 도달 가능한 정점 Set을 리턴 (중복 제거)
	static Set<Integer> search(int node, boolean[][] graph, Map<Integer, Set<Integer>> memo) {
		if (memo.containsKey(node))
			return memo.get(node);

		Set<Integer> reachable = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			if (graph[node][i]) {
				reachable.add(i);
				reachable.addAll(search(i, graph, memo));
			}
		}

		memo.put(node, reachable);
		return reachable;
	}
}
