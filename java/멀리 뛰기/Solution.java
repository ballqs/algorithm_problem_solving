class Solution {
    public long solution(int n) {
        long num1 = 0L;
        long num2 = 1L;
        long num3 = 0L;
        
        for (int i = 1; i <= n; i++) {
            num3 = (num1 + num2) % 1234567L;
            num1 = num2;
            num2 = num3;
        }
        return num3;
    }
}