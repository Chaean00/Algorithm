import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<String> dict = new ArrayList<>();
        List<Integer> results = new ArrayList<>();
        
        dict.add("emptry");
        for (int i=1; i<=26; i++) {
            char ch = (char) (i+64);
            dict.add(ch+"");
        }
        
        int i = 0;
        while (i < msg.length()) {
            String w = "";
            
            for (int end=i+1; end<=msg.length(); end++) {
                String str = msg.substring(i, end);
                if (!dict.contains(str)) break;
                w = str;
            }            
            results.add(dict.indexOf(w));
            
            int nextIndex = i + w.length();
            if (nextIndex < msg.length()) {
                String newEntry = w + msg.charAt(nextIndex);
                if (!dict.contains(newEntry)) {
                    dict.add(newEntry);
                }
            }
            
            i += w.length();
        }
        
        int[] answer = new int[results.size()];
        for (int k=0; k<answer.length; k++) {
            answer[k] = results.get(k);
        }
        
        return answer;
    }
}