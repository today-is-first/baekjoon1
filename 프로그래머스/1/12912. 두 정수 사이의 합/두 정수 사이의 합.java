class Solution {
    public long solution(int a, int b) {
        if(a==b) return a;
        double aver = (a+b)/2.0;
        long amount = Math.abs(a-b) + 1;
        return (long)(aver * amount);
    }
}