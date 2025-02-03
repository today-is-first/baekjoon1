import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Long> list = new ArrayList<>();
		list.add(1L);
		list.add(1L);
		list.add(1L);
		list.add(2L);
		list.add(2L);
		
		for(int i=5; i<= 100; i++) {
			long sum = list.get(i-2) + list.get(i-3);
			list.add(sum);
		}
		
		for(int i=0; i<n; i++) {
			int case1 = Integer.parseInt(br.readLine());
			System.out.println(list.get(case1-1));
			
		}
	}
}