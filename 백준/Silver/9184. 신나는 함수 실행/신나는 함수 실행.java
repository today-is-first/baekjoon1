import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][][] dp = new int[21][21][21];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            if (n[0] == -1 && n[1] == -1 && n[2] == -1) break;
            
            System.out.printf("w(%d, %d, %d) = %d\n", n[0], n[1], n[2], w(n[0], n[1], n[2]));
        }
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) 
            return 1;
            
        if (a > 20 || b > 20 || c > 20) 
            return w(20, 20, 20);
            
        if (dp[a][b][c] != 0) 
            return dp[a][b][c];
            
        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        } else {
            dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }
        
        return dp[a][b][c];
    }
}