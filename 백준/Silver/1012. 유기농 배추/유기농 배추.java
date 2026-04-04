// BOJ - 1012
import java.io.*;
import java.util.*;

class Point {
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][] arr;
	static boolean[][] visit;
	static int M, N, K;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t=0; t<T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	M = Integer.parseInt(st.nextToken());
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	
        	arr = new int[M][N];
        	visit = new boolean[M][N];
        	
        	for (int k=0; k<K; k++) {
        		st = new StringTokenizer(br.readLine());
        		
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		
        		arr[x][y] = 1;
        	}
        	
        	int count = 0;
        	
        	for (int i=0; i<M; i++) {
        		for (int j=0; j<N; j++) {
        			if (arr[i][j] == 1 && !visit[i][j]) {
        				bfs(i, j);
        				count++;
        			}
        		}
        	}
        	
        	System.out.println(count);
        }
    }
    
    public static void bfs(int x, int y) {
    	Queue<Point> q = new LinkedList<>();
    	
    	q.offer(new Point(x, y));
    	visit[x][y] = true;
    	
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		
    		for (int d=0; d<4; d++) {
    			int mx = p.x + dx[d];
    			int my = p.y + dy[d];
    			
    			if (mx < 0 || mx >= M || my < 0 || my >= N || visit[mx][my]) continue;
    			if (arr[mx][my] == 0) continue;
    			
    			visit[mx][my] = true;
    			q.offer(new Point(mx, my));
    		}
    	}
    }
}
