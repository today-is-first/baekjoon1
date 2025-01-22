import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
	public static boolean[][] map;
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		
		map = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == 'W')
					map[i][j] = true;
				else
					map[i][j] = false;

			}
		}

		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				find(i,j);
			}
		}

		System.out.println(min);
	}
	
	public static void find(int i, int j) {
		int changeAmount = 0;
		boolean type = map[i][j];
		
		for (int x = i; x < i + 8; x++) {
			for (int y = j; y < j + 8; y++) {
				if (type != map[x][y]) {
					changeAmount += 1;
				}
				type = !type;
			}
			
			type = !type;
		}

		changeAmount = Math.min(changeAmount, 64-changeAmount);
		min = Math.min(min, changeAmount);
	}
}
