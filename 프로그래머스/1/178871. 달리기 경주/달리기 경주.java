import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        
        for (int i=0; i<players.length; i++) {
            rank.put(players[i], i);
        }
        
        for (String name : callings) {
            int cur = rank.get(name);
            int front = cur - 1;
            
            String frontPlayer = players[front];
            players[front] = players[cur];
            players[cur] = frontPlayer;
            
            rank.put(frontPlayer, cur);
            rank.put(name, front);
            
        }
        return players;
    }
}