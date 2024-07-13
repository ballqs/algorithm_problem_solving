import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        //commands 길이 구하기 => return하는 int 배열크기가 commands와 관련 있기 때문
        int len = commands.length;
        int[] answer = new int[len];
        int cnt = 0;    //answer 배열 index용
        
        for(int i = 0; i < len; i++){
            //commands[][시작지점 , 종료지점 , K번째수]
            int first = commands[i][0] - 1; //시작지점은 -1를 함으로서 index 역할
            int second = commands[i][1];    //종료지점까지 포함되어야해서 -1처리 하면 안됨
            int tree = commands[i][2] - 1;  //K번째수에서는 index 역할해야해서 -1처리
            
            int[] res = new int[second - first];
            
            for(int j = first , k = 0; j < second; j++ , k++){
                res[k] = array[j];
            }
            
            //오름차순 정렬하기
            Arrays.sort(res);
            
            //값 담기
            answer[cnt] = res[tree];
            cnt++;
        }
        
        return answer;
    }
}