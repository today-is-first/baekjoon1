import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= TC; tc++) {
			char[] orderList = br.readLine().toCharArray();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			String[] strArr = str.substring(1, str.length() - 1).split(",");
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(strArr[i]));
			}

			boolean isReversed = false;
			boolean isError = false;

			for (int i = 0; i < orderList.length; i++) {
				if (orderList[i] == 'R') {
					isReversed = !isReversed;
					continue;
				}
				if (list.size() == 0) {
					isError = true;
					break;
				}
				if (isReversed) {
					list.removeLast();
				} else {
					list.removeFirst();
				}
			}

			if (isError)
				sb.append("error").append("\n");
			else if (isReversed) {
				Collections.reverse(list);
				sb.append(list.toString().replace(" ", "")).append("\n");
			} else
				sb.append(list.toString().replace(" ", "")).append("\n");
		}
		System.out.println(sb);
	}
}