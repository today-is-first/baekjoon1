import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int count = 0;
	static int N;
	static Meeting[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = 1;
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new Meeting[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				arr[i] = new Meeting(start, end);
			}
			Arrays.sort(arr, Comparator.comparing(Meeting::getEnd).thenComparing(Meeting::getStart));
			search();
			sb.append(count);
		}

		System.out.println(sb);
	}

	static void search() {
		int endTime = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			Meeting target = arr[i];
			if (endTime <= target.getStart()) {
				endTime = target.getEnd();
				count++;
			}
		}
	}

}

class Meeting {
	int start;
	int end;

	public Meeting() {
	}

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getEnd() {
		return end;
	}

	public int getStart() {
		return start;
	}

}