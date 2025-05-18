import java.util.*;

class Solution {
    class FileInfo {
        String og;
        String head;
        int number;
        
        FileInfo(String og, String head, int number) {
            this.og = og;
            this.head = head;
            this.number = number;
        }
    }
    public String[] solution(String[] files) {
        
        List<FileInfo> list = new ArrayList<>();
        for (int i=0; i<files.length; i++) {
            list.add(parse(files[i]));
        }
        
        Collections.sort(list, (a, b) -> {
           if (a.head.compareToIgnoreCase(b.head) != 0) {
               return a.head.compareToIgnoreCase(b.head);
           }
            
            return a.number - b.number;
        });
        
        String[] answer = new String[list.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = list.get(i).og;
        }
        
        return answer;
    }
    public FileInfo parse(String file) {
        String head = "";
        String number = "";
        
        int i = 0;
        while (i < file.length() && !Character.isDigit(file.charAt(i))) {
            head += file.charAt(i);
            i++;
        }
        
        while (i < file.length() && Character.isDigit(file.charAt(i))) {
            number += file.charAt(i);
            i++;
        }
        
        return new FileInfo(file, head, Integer.parseInt(number));
    }
}