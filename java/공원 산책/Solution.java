class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int width = park[0].length(); // 공원의 최대 가로 길이
        int height = park.length;     // 공원의 최대 세로 길이
        int dog_width = 0;  // 강아지 가로 시작위치
        int dog_height = 0; // 강아지 세로 시작위치
        
        // 공원 데이터 정리하기
        String[][] parks = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                parks[i][j] = park[i].charAt(j) + "";
                if((park[i].charAt(j) + "").equals("S")){
                    dog_height = i;
                    dog_width = j;
                }
            }
        }
        
        // 수행할 명령 리스트 실행
        for (int i = 0; i < routes.length; i++) {
            String[] info = routes[i].split(" ");
            int n = 0;
            int move = Integer.parseInt(info[1]);
            
            // 공원을 벗어나는지 검사
            if (info[0].equals("N") || info[0].equals("S")) {
                n = info[0].equals("N") ? -1 : 1;
                if (dog_height + (n * move) < 0 || dog_height + (n * move) >= height) continue;
            } else {
                n = info[0].equals("W") ? -1 : 1;
                if (dog_width + (n * move) < 0 || dog_width + (n * move) >= width) continue;
            }
            
            // 장애물있는지 검사하다가 되돌려야 할 경우
            int tmp_height = dog_height;
            int tmp_width = dog_width;
            
            boolean flag = true;
            
            // 이동거리에 장애물이 있는지 검사
            for (int j = 0; j < move; j++) {
                if (info[0].equals("N") || info[0].equals("S")) {
                    tmp_height+=n;
                } else {
                    tmp_width+=n;
                }
                if (parks[tmp_height][tmp_width].equals("X")) {
                    flag = false;
                    break;
                }
            }
            
            // 이동에 문제 없을때 이동한것으로 간주
            if (flag) {
                dog_height = tmp_height;
                dog_width = tmp_width;
            }
        }
        
        answer[0] = dog_height;
        answer[1] = dog_width;
        
        return answer;
    }
}