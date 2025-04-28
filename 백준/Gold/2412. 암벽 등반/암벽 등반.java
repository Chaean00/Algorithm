import java.util.*;
import java.io.*;
class Point {
	int x, y, cnt;
	
	Point(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main {
	static int n, T;
	static int[] dx = {2, 1, 0, -1, -2};
	static int[] dy = {2, 1, 0, -1, -2};
	static Set<String> slots = new HashSet<>();
	static Queue<Point> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			slots.add(x + "," + y);
		}
		
		int count = bfs();
		
		System.out.println(count);
	}
	
	public static int bfs() {
		q.offer(new Point(0, 0, 0));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			if (p.y == T) return p.cnt;
			
			for (int i=0; i<5; i++) {
				for (int j=0; j<5; j++) {
					if (dx[i] == 0 && dy[j] == 0) continue;
					
					int mx = p.x + dx[i];
					int my = p.y + dy[j];
					
					String next = mx + "," + my;
					
					if (slots.contains(next)) {
						slots.remove(next);
						q.add(new Point(mx, my, p.cnt + 1));
					}
				}
			}
		}
		
		return -1;
		
		
	}
}
