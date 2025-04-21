// 못풀어서 블로그보고 풀어버림 ㅜ
import java.util.*;
import java.io.*;

class Node {
	int position;
	int time;
	
	public Node(int position, int time) {
        this.position = position;
        this.time = time;
    }
}


public class Main {
	static int N, K;
	static int min = Integer.MAX_VALUE;
	static int count = 0;
	static int[] visit = new int[100001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Arrays.fill(visit, -1);
		
		bfs();
		
		System.out.println(min);
		System.out.println(count);
	}
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(N, 0));
		visit[N] = 0;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int curPos = cur.position;
			int curTime = cur.time;
			
			if (curPos == K) {
				if (curTime < min) {
					min = curTime;
					count = 1;
				} else if (curTime == min) {
					count++;
				}
				continue;
			}
			
			for (int next : new int[] {curPos - 1, curPos + 1, curPos * 2}) {
				if (next < 0 || next > 100000) continue;
				
				if (visit[next] == -1 || visit[next] == curTime + 1) {
					visit[next] = curTime + 1;
					q.offer(new Node(next, curTime + 1));
				}
			}
		}
		
	}
}
