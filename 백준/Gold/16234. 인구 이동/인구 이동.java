// BOJ - 16234
import java.io.*;
import java.util.*;

class Point {
	int x, y;
	
	Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[] DX = {-1, 0, 1, 0};
	static int[] DY = {0, -1, 0, 1};
	static int N,L,R;
	static int[][] arr;
	static boolean[][] visit;
	static List<List<Point>> teams;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        int day = 0;
        
        arr = new int[N][N];
        
        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        while (true) {
        	visit = new boolean[N][N];
        	teams = new ArrayList<>();
        	
        	for (int i=0; i<N; i++) {
        		for (int j=0; j<N; j++) {
        			if (!visit[i][j]) bfs(i, j);
        		}
        	}
        	
        	if (teams.isEmpty()) {
        		break;
        	} else {
        		for (List<Point> team : teams) {
        			int sum = 0;
        			int count = team.size();
        			
        			for (Point p : team) sum += arr[p.x][p.y];
        			for (Point p : team) arr[p.x][p.y] = sum / count;
        		}
        	}
        	
        	day++;
        }
        
        System.out.println(day);
    }
    
    public static void bfs(int x, int y) {
    	Queue<Point> q = new LinkedList<>();
    	List<Point> team = new ArrayList<>();
    	
    	q.offer(new Point(x, y));
    	visit[x][y] = true;
    	team.add(new Point(x, y));
    	
    	while (!q.isEmpty()) {
    		Point p = q.poll();
    		
    		for (int d=0; d<4; d++) {
    			int nx = p.x + DX[d];
    			int ny = p.y + DY[d];
    			
    			if (nx >= N || ny >= N || nx < 0 || ny < 0) continue;
    			if (visit[nx][ny]) continue;
    			
    			int diff = Math.abs(arr[nx][ny] - arr[p.x][p.y]);
    			
    			if (diff >= L && diff <= R) {
    				visit[nx][ny] = true;
    				q.offer(new Point(nx, ny));
    				team.add(new Point(nx, ny));
    			}
    		}
    	}
    	
    	if (team.size() >= 2) {
    		teams.add(team);
    	}
    	
    }
}
