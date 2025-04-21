import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] map;
	static boolean[] visit;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map[u][v] = true;
			map[v][u] = true;
		}
		
		int count = 0;
		
		for (int i=1; i<N+1; i++) {
			if (!visit[i]) {
				bfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visit[start] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i=1; i<N+1; i++) {
				if (map[cur][i] && !visit[i]) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}
