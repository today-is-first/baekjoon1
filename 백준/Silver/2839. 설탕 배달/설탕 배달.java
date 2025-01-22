import java.util.Scanner;

public class Main {
	public static boolean[][] map;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = Integer.MAX_VALUE;

		int max5 = n / 5;

		while (max5 >= 0) {
			int num = n;
			num -= 5 * max5;
			int count3 = num / 3;
			num %= 3;
			if (num == 0)
				min = Math.min(min, max5 + count3);
			max5--;
		}

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}
}
