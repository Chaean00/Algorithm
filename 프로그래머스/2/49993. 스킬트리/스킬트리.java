import java.util.*;

class Solution {
    static int answer = 0;
    static List<String> skills = new ArrayList<>();
    
    public int solution(String skill, String[] skill_trees) {
        
        for (int i=0; i<skill.length(); i++) {
            skills.add(skill.charAt(i) + "");
        }
        
        for (int i=0; i<skill_trees.length; i++) {
            boolean[] visit = new boolean[skills.size()];
            
            isPossible(skill_trees[i], visit);
        }
        return answer;
    }
    
    public void isPossible(String skillTree, boolean[] visit) {
        for (int i=0; i<skillTree.length(); i++) {
            String ch = skillTree.charAt(i) + "";
            
            if (!skills.contains(ch)) continue;
            
            int idx = skills.indexOf(ch);
            
            for (int j=0; j<idx; j++) {
                if (!visit[j]) {
                    return;
                }
            }
            
            visit[idx] = true;
        }
        
        answer++;
    }
}