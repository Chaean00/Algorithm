import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] map;
	static boolean[] visit;
	static int N, M, V;
	static StringBuilder sbBfs = new StringBuilder();
	static StringBuilder sbDfs = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		visit = new boolean[N+1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map[u][v] = true;
			map[v][u] = true;
		}
		
		bfs(V);
		
		visit = new boolean[N+1];
		
		dfs(V);
		
		System.out.println(sbDfs);
		System.out.println(sbBfs);

	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visit[start] = true;
		sbBfs.append(start).append(" ");
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i=1; i<N+1; i++) {
				if (map[cur][i] && !visit[i]) {
					visit[i] = true;
					q.offer(i);
					sbBfs.append(i).append(" ");
				}
			}
		}
	}
	
	public static void dfs(int start) {
		visit[start] = true;
		sbDfs.append(start).append(" ");
		
		for (int i=1; i<N+1; i++) {
			if (map[start][i] && !visit[i]) {
				dfs(i);
			}
		}
		
	}
}
