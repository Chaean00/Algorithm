import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> solution(String s) {
        int[] answer = {};
        String[] strArr = s.split(",");
        Map<Integer, Integer> map = new LinkedHashMap<>();
        
        for (int i=0; i<strArr.length; i++) {
            String str = strArr[i];
            String temp = "";
            
            for (int j=0; j<str.length(); j++) {
                char ch = str.charAt(j);
                
                if (Character.isDigit(ch)) temp += ch + "";
            }
        
            map.put(Integer.parseInt(temp), map.getOrDefault(Integer.parseInt(temp), 0) + 1);
        }
        
        List<Integer> sortedKeys = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        
        return sortedKeys;
    }
}