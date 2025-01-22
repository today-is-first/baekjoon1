import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();  // 출력 누적용
        
        int n = Integer.parseInt(br.readLine());
        List<Integer> li = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            
            switch(cmd) {
                case 1:
                    li.add(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    sb.append(li.size() > 0 ? li.remove(li.size() - 1) : -1).append('\n');
                    break;
                case 3:
                    sb.append(li.size()).append('\n');
                    break;
                case 4:
                    sb.append(li.isEmpty() ? 1 : 0).append('\n');
                    break;
                case 5:
                    sb.append(li.size() > 0 ? li.get(li.size() - 1) : -1).append('\n');
                    break;
            }
        }
        
        System.out.print(sb);  // 한 번에 출력
    }
}