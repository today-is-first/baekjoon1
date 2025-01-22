import java.util.Scanner;

public class Main {
	public static boolean[][] map;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 1_000_000_000;
		int count =0;
		
		for(int i=666; i<=max; i++) {
			String str = Integer.toString(i);
			if(str.contains("666")) {
				count +=1;
				if(count == n) {
					System.out.println(i);
					break;
				} 
			}
		}		
		
	}
}
