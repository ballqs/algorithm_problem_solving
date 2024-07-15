class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        // a => 마트에 가져다 줘야 할 콜라 병 개수
        // b => a병만큼 가져다주면 돌려주는 병 개수
        // n => 내가 가지고 있는 총 병 개수
        
        while(true){
            answer += n / a * b;      // n / a * b
            n = n / a * b + n % a;    // n / a * b + 나머지
            if(n < a || n < 2){
                break;
            }
        }
        
        return answer;
    }
}