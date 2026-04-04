// BOJ - 14502
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
	static int[][] map;
	static int N, M;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        List<Point> empty = new ArrayList<>();
        
        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0; j<M; j++) {
        		int value = Integer.parseInt(st.nextToken());
        		map[i][j] = value;
        		
        		if (value == 0) {
        			empty.add(new Point(i, j));
        		}
        	}
        }
        
        
        int answer = Integer.MIN_VALUE;
        for (int i=0; i<empty.size(); i++) {
        	for (int j=i+1; j<empty.size(); j++) {
        		for (int k=j+1; k<empty.size(); k++) {
        			
        			Point p1 = empty.get(i);
        			Point p2 = empty.get(j);
        			Point p3 = empty.get(k);
        			
        			map[p1.x][p1.y] = 1;
        			map[p2.x][p2.y] = 1;
        			map[p3.x][p3.y] = 1;
        			
        			
                    // map 복사
                    int[][] copyMap = new int[N][M];
                    for (int a = 0; a < N; a++) {
                        for (int b = 0; b < M; b++) {
                            copyMap[a][b] = map[a][b];
                        }
                    }

                    virus(copyMap);
        			
        			int count = 0;
        			for (int w=0; w<N; w++) {
        				for (int e=0; e<M; e++) {
        					if (copyMap[w][e] == 0) count++;
        				}
        			}
        			
        			answer = Math.max(answer, count);
        			
        			map[p1.x][p1.y] = 0;
        			map[p2.x][p2.y] = 0;
        			map[p3.x][p3.y] = 0;
        		}
        	}
        }
        
        System.out.println(answer);
    }
    
    public static void bfs(int x, int y, int[][] copyMap) {
    	Queue<Point> q = new LinkedList<>();
    	
    	q.offer(new Point(x, y));
    	
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		
    		for (int d=0; d<4; d++) {
    			int mx = p.x + dx[d];
    			int my = p.y + dy[d];
    			
    			if (mx < 0 || mx >= N || my < 0 || my >= M) continue;
    			if (copyMap[mx][my] == 1) continue;
    			
    			if (copyMap[mx][my] == 0) {
    				q.offer(new Point(mx, my));
    				copyMap[mx][my] = 2;
    			}
    		}
    	}
    }
    
    public static void virus(int[][] copyMap) {
    	for (int i=0; i<N; i++) {
    		for (int j=0; j<M; j++) {
    			if (copyMap[i][j] == 2) {
    				bfs(i, j, copyMap);
    			}
    		}
    	}
    }
}
