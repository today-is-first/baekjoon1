import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		List<Integer> arr = new ArrayList<Integer>();
		int result = Integer.MAX_VALUE;
		
		StringTokenizer stt = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(stt.nextToken());
			if (num == 1) arr.add(i);
		}
		
		if(arr.size() < count) {
			System.out.println(-1);
			return;
		}

		int[] intArr = arr.stream().mapToInt(Integer::intValue).toArray();
		for (int i = count-1; i < arr.size(); i++) {
			int sum = intArr[i] - intArr[i-count+1] + 1;
			result = sum > result ? result : sum;
		}
		
		System.out.println(result);
	}
}