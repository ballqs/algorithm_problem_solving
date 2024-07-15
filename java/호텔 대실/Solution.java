import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        //청소시간
        int cleanTime = 10;
        int maxTime = 24 * 60;
        
        int[][] bookTime = new int[book_time.length][2];
        
        //1) book_time를 수치화 하기
        for(int i = 0; i < book_time.length; i++){
            for(int j = 0; j < book_time[i].length; j++){
                String[] time = book_time[i][j].split(":");
                bookTime[i][j] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            }
        }
        
        //2) 입장 시간별로 정리
        Arrays.sort(bookTime, new Comparator<int[]>() {
        @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0]; // 첫번째 숫자 기준 오름차순 {1,30}{2,10}{3,50}{4,20}{5,40}
                //return o2[0]-o1[0]; // 첫번째 숫자 기준 내림차순 {5,40}{4,20}{3,50}{2,10}{1,30}
                //return o1[1]-o2[1]; // 두번째 숫자 기준 오름차순 {2,10}{4,20}{1,30}{5,40}{3,50}
                //return o2[1]-o1[1]; // 두번째 숫자 기준 내림차순 {3,50}{5,40}{1,30}{4,20}{2,10}
            }
        });
        
        ArrayList<boolean[]> room = new ArrayList<>();
        room.add(new boolean[maxTime]);
        //3) 호텔 대실를 위한 반복문
        for(int i = 0; i < bookTime.length; i++){
            int number = -1;
            for(int j = 0; j < room.size(); j++){
                boolean[] target = room.get(j);
                
                if((target[bookTime[i][0]] || target[bookTime[i][1]])){
                }else{
                    number = j;
                    break;
                }
            }
            
            if(number < 0){
                room.add(new boolean[maxTime]);
                number = room.size() - 1;
            }
            
            for(int k = bookTime[i][0]; k < bookTime[i][1] + 10; k++){
                boolean[] target = room.get(number);
                if(k < maxTime){
                    target[k] = true;
                }
            }
        }
        
        answer = room.size();
        
        return answer;
    }
}