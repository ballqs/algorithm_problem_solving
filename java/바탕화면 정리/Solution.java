class Solution {
    public int[] solution(String[] wallpaper) {
        
        //1) 드래그 시작점(start , min) 과 드래그 끝점(end , max) 값을 선언
        int start = -1; //바탕화면에 적어도 하나의 파일은 확정적으로 있기에 -1로 처리
        int end = 0;
        int min = 50;
        int max = 0;
        
        for(int i = 0; i < wallpaper.length; i++){
            //2) 해당 문자열의 처음부터 #이 있는지 검사하며 변수 저장
            int findshop = wallpaper[i].indexOf("#");
            
            //3) 해당 문자열의 마지막부터 #이 있는지 검사하며 변수 저장
            int findlastshop = wallpaper[i].lastIndexOf("#");
            
            //4) start는 보통 한번만 저장(이후에 저장할 필요 없음)
            if(findshop > -1 && start == -1){
                start = i;
            }
            
            //5) #시작점의 최소값 구하기
            if(findshop > -1 && min != 0){
                if(findshop < min){
                    min = findshop;
                }
            }
            
            //6) end는 차차 값을 늘려가며 최종지점을 찾아서 변수 저장
            if(findlastshop > -1){
                end = i;
            }
            
            //7) #끝점의 최대값 구하기
            if(findlastshop > max){
                max = findlastshop;
            }
        }
        
        //8) 반환값을 만들어 반환한다.
        int[] answer = {start , min , end+1 , max+1};
        
        return answer;
    }
}