class Solution {
    boolean solution(String s) {
        int pAmount = 0;
        int yAmount = 0;
        
        // 문자열 자체에서 반복문을 사용하여 p와 y의 개수 세기
        for (char ch : s.toLowerCase().toCharArray()) {
            if (ch == 'p') pAmount++;
            if (ch == 'y') yAmount++;
        }
            
        return pAmount == yAmount;
    }
}
