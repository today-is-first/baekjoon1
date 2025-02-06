import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).forEach(num -> {
			if (map.containsKey(num))
				return;
			map.put(num, 1);
		});

		int m = Integer.parseInt(br.readLine());
		List<Integer> numArr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
				.collect(Collectors.toList());

		numArr.forEach(num -> {
			System.out.print(map.containsKey(num) ? 1 : 0);
			System.out.print(" ");

		});

	}

}