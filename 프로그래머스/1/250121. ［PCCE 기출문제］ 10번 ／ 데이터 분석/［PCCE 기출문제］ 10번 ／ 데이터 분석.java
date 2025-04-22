import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extCode = getIndex(ext);
        int sortCode = getIndex(sort_by);
        
        List<List<Integer>> result = new ArrayList<>();
        
        if (ext.equals("code")) {
            extCode = 0;
        } else if (ext.equals("date")) {
            extCode = 1;
        } else if (ext.equals("maximum")) {
            extCode = 2; 
        } else if (ext.equals("remain")) {
            extCode = 3;
        }
        
        for (int i=0; i<data.length; i++) {
            if(data[i][extCode] < val_ext) {
                List<Integer> row = new ArrayList<>();
                for (int j=0; j<data[i].length; j++) {
                    row.add(data[i][j]);
                }
                result.add(row);
            }
        }
        
        result.sort((a1, a2) -> {
            return a1.get(sortCode) - a2.get(sortCode);
        });
        
        int[][] answer = new int[result.size()][result.get(0).size()];
        
        for (int i=0; i<answer.length; i++) {
            for (int j=0; j<answer[i].length; j++) {
                answer[i][j] = result.get(i).get(j);
            }
        }
        
        return answer;
    }
    
    private int getIndex(String key) {
        if (key.equals("code")) {
            return 0;
        } else if (key.equals("date")) {
            return 1;
        } else if (key.equals("maximum")) {
            return 2;
        } else {
            return 3;
        }
    }
}