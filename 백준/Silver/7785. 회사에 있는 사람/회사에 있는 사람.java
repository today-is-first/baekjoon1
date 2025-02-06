
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, String> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String[] strArr = br.readLine().split(" ");
			if (strArr[1].toString().equals("enter")) {
				map.put(strArr[0], strArr[1]);
			} else {
				if (!map.containsKey(strArr[0]))
					continue;
				map.remove(strArr[0]);
			}

		}

		map.keySet().stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

	}

}