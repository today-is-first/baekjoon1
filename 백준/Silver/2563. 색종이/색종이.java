import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    
    // 도화지를 표현하는 2차원 배열 (false: 흰색, true: 검은색)
    boolean[][] paper = new boolean[100][100];
    
    // 각 색종이 위치 처리
    for(int i = 0; i < n; i++) {
        String[] str = sc.nextLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        
        // 색종이가 덮는 영역을 true로 표시
        for(int dx = 0; dx < 10; dx++) {
            for(int dy = 0; dy < 10; dy++) {
                paper[x + dx][y + dy] = true;
            }
        }
    }
    
    // 검은 영역(true) 카운트
    int blackArea = 0;
    for(int i = 0; i < 100; i++) {
        for(int j = 0; j < 100; j++) {
            if(paper[i][j]) blackArea++;
        }
    }
    
    System.out.println(blackArea);
}
}
