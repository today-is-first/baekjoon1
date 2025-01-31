import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
 		dfs(2, 1, n, 1);
	}
	
	private static void dfs(int depth, int sum, int n, int prev) {
		if(n == 0) {
			System.out.println(0);
			return;
		}
		
		if(n == 1) {
			System.out.println(1);
			return;
		}
		
		if(depth == n) {
			System.out.println(sum);
			return;
		}
		
		dfs(++depth, sum+prev, n, sum);

	}
}