import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int[][] box = new int[(n/w)+1][w];
        
        int count = 1;
        int i = 0;
        int x = -1;
        int y = -1;
        while (count <= n) {
            if (i % 2 == 0) {
                for (int j=0; j<box[i].length; j++) {
                    if (count > n) break;
                    if (count == num) {
                        x = i;
                        y = j;
                    }
                    box[i][j] = count;
                    count++;
                }
            } else {
                for (int j=box[i].length-1; j>=0; j--) {
                    if (count > n) break;
                    if (count == num) {
                        x = i;
                        y = j;
                    }
                    box[i][j] = count;
                    count++;
                }
            }
            i++;
        }
        
        for (int idx=x; idx<box.length; idx++) {
            if (box[idx][y] != 0) {
                answer++;
            }
        }
        return answer;
    }
}