import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int result = 0;  // 결과를 저장할 변수
        
        for(int i = 1; i < n; i++) {
            int sum = i;
            int num = i;
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }
            
            if(sum == n) {
                result = i;  // 생성자를 찾으면 저장
                break;
            }
        }
        
        System.out.println(result);  // 못 찾으면 0, 찾으면 해당 값 출력
    }
}