class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (long l = 1; l <= n; l++) {
            answer[(int) l - 1] = x * l;
        }
        return answer;
    }
}