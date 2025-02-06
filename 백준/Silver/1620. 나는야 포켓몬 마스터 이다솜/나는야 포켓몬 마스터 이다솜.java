
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = arr[0];
		int M = arr[1];
		int result = 0;

		StringBuilder sb = new StringBuilder();

		String[] strArr = new String[N];
		String[] inspectArr = new String[M];
		
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			strArr[i] = str;
			map.put(str, i+1);
		}

		for (int i = 0; i < M; i++) {
			inspectArr[i] = br.readLine();
			
		}

		for (int i = 0; i < M; i++) {
			if (inspectArr[i].matches("\\d+")) {
				sb.append(strArr[Integer.parseInt(inspectArr[i]) - 1]).append("\n");
				continue;
			}
			sb.append(map.get(inspectArr[i])).append("\n");
		}

		System.out.println(sb.toString());
	}

}