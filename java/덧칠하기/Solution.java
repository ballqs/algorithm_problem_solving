class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        // n길이만큼의 벽이 있음
        // m길이만큼 칠할수 있음
        // section에 적힌 곳은 다시 칠해야함
        
        // 벽 생성
        boolean[] coloring_yn = new boolean[n];
        for(int i = 0; i < section.length; i++){
            coloring_yn[section[i] - 1] = true;
        }
        
        // m길이만큼 칠하는 로직
        for(int i = 0; i < n; i++){
            if(coloring_yn[i]){ // true인 경우 칠해야 함
                for(int j = 1; j < m; j++){ // m길이만큼 색칠
                    if(i + j < n){  // index 에러 방지
                        coloring_yn[i + j] = false;
                    }else{
                        break;
                    }
                }
                answer++;
            }
        }
        
        return answer;
    }
}