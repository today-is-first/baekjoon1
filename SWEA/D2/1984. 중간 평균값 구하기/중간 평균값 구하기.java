import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		for (int j = 1; j <= n; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < 10; i++)
				list.add(Integer.parseInt(st.nextToken()));

			List<Integer> li = list.stream().mapToInt(Integer::intValue).sorted().boxed().collect(Collectors.toList());
			double sum = (double) list.stream().mapToInt(Integer::intValue).sum() - li.get(li.size() - 1) - li.get(0);
			double aver = Math.round(sum / 8);

			sb.append("#").append(j).append(" ").append((int) aver).append("\n");
		}
		System.out.println(sb.toString());

	}

}