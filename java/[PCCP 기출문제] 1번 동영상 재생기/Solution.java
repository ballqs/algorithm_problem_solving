class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int video = convertTimeToInt(video_len);
        int start = convertTimeToInt(pos);
        int opStartDt = convertTimeToInt(op_start);
        int opEndDt = convertTimeToInt(op_end);
        
        start = opCheck(start , opStartDt , opEndDt);
        
        for (String command : commands) {
            switch (command) {
                case "next":
                    start += 10;
                    if (start > video) {
                        start = video;
                    }
                    break;
                case "prev":
                    start -= 10;
                    if (start < 0) {
                        start = 0;
                    }
                    break;
            }
            start = opCheck(start , opStartDt , opEndDt);
        }
        
        
        return converIntToTime(start);
    }
    
    public int opCheck(int start , int opStartDt , int opEndDt) {
        if (opStartDt <= start && opEndDt >= start) {
            start = opEndDt;
        }
        return start;
    }
    
    public int convertTimeToInt(String times) {
        String time[] = times.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
    public String converIntToTime(int time) {
        int minute = time / 60;
        int second = time % 60;
        return String.format("%02d", minute) + ":" + String.format("%02d", second);
    }
}