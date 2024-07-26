class Solution {
    public int[] solution(long n) {
        int[] answer = new int[Long.toString(n).length()];
        for (int i = Long.toString(n).length() - 1 , j = 0; i >= 0; i-- , j++) {
            answer[j] = Long.toString(n).charAt(i) - '0';
        }
        return answer;
    }
}