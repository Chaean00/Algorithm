import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();
        List<String> text = new ArrayList<>();
        
        for (int i=0; i<record.length; i++) {
            String data[] = record[i].split(" ");
            
            if (data[0].equals("Enter")) {
                user.put(data[1], data[2]);
                text.add(data[1] + "님이 들어왔습니다.");
            } else if (data[0].equals("Leave")) {
                text.add(data[1] + "님이 나갔습니다.");
            } else if (data[0].equals("Change")) {
                user.put(data[1], data[2]);
            }
        }
        
        for (int i=0; i<text.size(); i++) {
            String str = text.get(i);
            int idx = str.indexOf("님");
            String sub = str.substring(0, idx);
            String last = str.substring(idx);
            
            String name = user.get(sub);
            
            text.set(i, name + last);
        }
        
        String[] answer = new String[text.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = text.get(i);
        }
        return answer;
    }
}