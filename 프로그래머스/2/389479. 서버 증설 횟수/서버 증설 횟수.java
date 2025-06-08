import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        List<Integer> server = new ArrayList<>();
        
        for (int i=0; i<players.length; i++) {
            for (int idx = server.size() - 1; idx >= 0; idx--) {
                server.set(idx, server.get(idx) - 1);
                if (server.get(idx) == 0) server.remove(idx);
            }
            
            int serverCount = server.size() * m;
            
            if (players[i] < m) continue;
            if (players[i] <= serverCount) continue;
            
            int count = players[i] - serverCount;
            
            for (int j=0; j<count / m; j++) {
                server.add(k);
                answer++;
            }
            
        }
        return answer;
    }
}