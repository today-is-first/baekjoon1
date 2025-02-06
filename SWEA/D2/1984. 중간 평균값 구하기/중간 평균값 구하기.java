
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int j = 1; j <= n; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < 10; i++)
				list.add(Integer.parseInt(st.nextToken()));

			int max = list.stream().mapToInt(Integer::intValue).max().getAsInt();
			int min = list.stream().mapToInt(Integer::intValue).min().getAsInt();
			double sum = (double) list.stream().mapToInt(Integer::intValue).sum() - max - min;
			double aver = Math.round(sum / 8);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(j).append(" ").append((int) aver);
			System.out.println(sb.toString());
		}

	}

}