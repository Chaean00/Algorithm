import java.util.*;

class Solution {
    class Point {
        int x, count;

        Point(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
    
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Queue<Point> q = new LinkedList<>();
        boolean[] visit = new boolean[y+1];
        
        q.offer(new Point(x, 0));
        visit[x] = true;
        
        while (!q.isEmpty()) {
            Point point = q.poll();
            int value = point.x;
            
            if (value == y) {
                return point.count;
            }
            
            if (value + n <= y && !visit[value + n]) {
                q.offer(new Point(value + n, point.count + 1));
                visit[value + n] = true;
            }
            if (value * 2 <= y && !visit[value * 2]) {
                q.offer(new Point(value * 2, point.count + 1));
                visit[value * 2] = true;
            }
            if (value * 3 <= y && !visit[value * 3]) {
                q.offer(new Point(value * 3, point.count + 1));
                visit[value * 3] = true;
            }
        }
        
        return answer;
    }
}