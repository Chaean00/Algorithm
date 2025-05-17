import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> cars = new HashMap<>();
        Map<String, Integer> times = new HashMap<>();
        
        for (int i=0; i<records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            String[] timeStr = st.nextToken().split(":");
            int time = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);
            String number = st.nextToken();
            String type = st.nextToken();
            
            if (type.equals("IN")) {
                cars.put(number, time);
                continue;
            }
            
            int totalTime = time - cars.get(number);
            
            times.put(number, times.getOrDefault(number, 0) + totalTime);
            cars.remove(number);
        }
        
        for (String key : cars.keySet()) {
            int value = cars.get(key);
            int endTime = (23 * 60) + 59;
            
            times.put(key, times.getOrDefault(key, 0) + endTime - value);
        }
        
        String[][] temp = new String[times.size()][2];
        
        int i = 0;
        for (String key : times.keySet()) {
            int value = times.get(key);
            
            temp[i][0] = key;
            
            if (value <= fees[0]) {
                temp[i][1] = fees[1] + "";
            } else {
                double time = value - fees[0];
                time = time / fees[2];
                time = Math.ceil(time);
                temp[i][1] = (time * fees[3] + fees[1]) + "";
            }
            i++;
        }
        
        Arrays.sort(temp, (a, b) -> {
            int aNum = Integer.parseInt(a[0]);
            int bNum = Integer.parseInt(b[0]);
            return Integer.compare(aNum, bNum);
        });
        
        int[] answer = new int[temp.length];
        for (int a=0; a<temp.length; a++) {
            answer[a] = (int) Double.parseDouble(temp[a][1]);
        }
        
        return answer;
    }
}