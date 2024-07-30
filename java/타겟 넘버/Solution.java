class Solution {
    int len = 0;
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        dfs(numbers , 0 , 0 , target);
        return answer;
    }
    
    public void dfs(int[] numbers , int idx , int sum , int target) {
        if (idx == len) {
            if (sum == target) {
                answer++;
            }
        } else {
            String[] sign = {"+" , "-"};
            for (int i = 0; i < sign.length; i++) {
                if (sign[i] == "+") {
                    dfs(numbers , idx + 1, sum + numbers[idx] , target);
                } else {
                    dfs(numbers , idx + 1, sum - numbers[idx] , target);
                }
            }
        }
    }
}