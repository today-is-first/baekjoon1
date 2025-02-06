
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;
		String[] strArr = new String[N];
		String[] inspectArr = new String[M];

		for (int i = 0; i < N; i++)
			strArr[i] = br.readLine();
		for (int i = 0; i < M; i++)
			inspectArr[i] = br.readLine();

		for (String s : inspectArr) {
			for (String str : strArr) {
				if (str.equals(s)) {
					result += 1;
				}
				
			
			}
		}

		System.out.println(result);
	}

}