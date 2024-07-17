class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 학생들의 번호는 체격 순으로 매겨져 있다(오름차순? 내림차순?)
        // 전체 학생의 수 n , 체육복을 도난당한 학생들 번호 lost , 여벌의 체육복을 가져온 reserve
        // 여벌옷을 가지고 온 학생이 도난당한 경우?
        
        boolean[] lost_student = new boolean[n];
        boolean[] extra_clothes_student = new boolean[n];
        
        for(int i = 0; i < lost.length; i++){
            //체육복을 도둑맞았다는 의미
            lost_student[lost[i] - 1] = true;
        }
        
        for(int i = 0; i < reserve.length; i++){
            if(lost_student[reserve[i] - 1]){
                //여분의 옷 가지고 온 학생이 도난 당한 경우
                lost_student[reserve[i] - 1] = false;
                extra_clothes_student[reserve[i] - 1] = false;
            }else{
                //여분의 옷
                extra_clothes_student[reserve[i] - 1] = true;
            }
        }
        
        // 체육복 빌러주기 로직
        for(int i = 0; i < n; i++){
            if(lost_student[i]){
                if(i - 1 > -1 && extra_clothes_student[i - 1]){
                    lost_student[i] = false;
                    extra_clothes_student[i - 1] = false;
                }else if(i + 1 < n && extra_clothes_student[i + 1]){
                    lost_student[i] = false;
                    extra_clothes_student[i + 1] = false;
                }
            }
        }
        
        // 수업을 들을수 있는 학생 카운트
        for(int i = 0; i < n; i++){
            if(!lost_student[i]){
                answer++;
            }
        }
        
        return answer;
    }
}