import java.util.*;

public class Solution {
    public int solution(int n) {
        String str = String.valueOf(n);
        String[] strArr = str.split("");
        int result = Arrays.stream(strArr).mapToInt(Integer::parseInt).sum();
        return result;
    }
}