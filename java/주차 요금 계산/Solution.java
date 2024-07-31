import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int finalTime = 23 * 60 + 59;
        
        Map<String , History> his = new HashMap<>();
        
        for (String arr : records) {
            String[] info = arr.split(" ");
            if (his.containsKey(info[1])) {
                History history = his.get(info[1]);
                if (info[2].equals("OUT")) {
                    history.setCumulativeTime(history.getCumulativeTime() + history.convertTime(info[0]) - history.getHistoryTime());
                }
                history.setHistoryTime(info[0]);
                history.setParkingStat(info[2]);
                his.put(info[1] , history);
            } else {
                his.put(info[1] , new History(info[0] , info[2] , 0));
            }
        }
        
        for (String number : his.keySet()) {
            History history = his.get(number);
            if (history.getParkingStat().equals("IN")) {
                history.setCumulativeTime(history.getCumulativeTime() + finalTime - history.getHistoryTime());
                his.put(number , history);
            }
        }

        int[] answer = new int[his.size()];
        int n = 0;
        
        List<String> keySet = new ArrayList<>(his.keySet());
        Collections.sort(keySet);
        for (String number : keySet) {
            History history = his.get(number);
            int cumulative = history.getCumulativeTime();
            
            int money = 0;
            if (cumulative <= fees[0]) {
                money = fees[1];
            } else {
                money = fees[1] + ((cumulative - fees[0]) / fees[2]) * fees[3];
                if ((cumulative - fees[0]) % fees[2] > 0) {
                    money += fees[3];
                }
            }
            answer[n] = money;
            n++;
        }
        
        return answer;
    }
}

class History {
    private int historyTime;
    private String parkingStat;
    private int cumulativeTime;
    
    History(String historyTime , String parkingStat , int cumulativeTime) {
        this.historyTime = convertTime(historyTime);
        this.parkingStat = parkingStat;
        this.cumulativeTime = cumulativeTime;
    }
    
    public int convertTime(String hhmm) {
        String[] time = hhmm.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
    public int getHistoryTime() {
        return this.historyTime;
    }
    
    public String getParkingStat() {
        return this.parkingStat;
    }
    
    public int getCumulativeTime() {
        return this.cumulativeTime;
    }
    
    public void setHistoryTime(String historyTime) {
        this.historyTime = convertTime(historyTime);
    }
    
    public void setParkingStat(String parkingStat) {
        this.parkingStat = parkingStat;
    }
    
    public void setCumulativeTime(int cumulativeTime) {
        this.cumulativeTime = cumulativeTime;
    }
    
}