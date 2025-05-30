import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int value = N * N;
		int dir = 1;
		
		int dx = 0;
		int dy = 0;
		
		int x = 0;
		int y = 0;
		
		int[][] map = new int[N][N];
		
		
		while (value >= 1) {
			if (value == M) {
				x = dx;
				y = dy;
			}
			
			if (map[dx][dy] == 0) {
				map[dx][dy] = value;
				value--;
			}
			
			
			if (dir == 1) { // 아래
				dx++;
				if (dx >= N || map[dx][dy] != 0) {
					dx--;
					dir++;
				}
			}
			if (dir == 2) { // 오른쪽  
				dy++;
				if (dy >= N || map[dx][dy] != 0) {
					dy--;
					dir++;
				}
			}
			if (dir == 3) { // 위 
				dx--;
				if (dx < 0 || map[dx][dy] != 0) {
					dx++;
					dir++;
				}
			}
			if (dir == 4) { // 왼쪽
				dy--;
				if (dy < 0 || map[dx][dy] != 0) {
					dy++;
					dir++;
				}
			}
			
			if (dir > 4) {
				dir = 1;
			}
					
			
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		sb.append(x+1).append(" ").append(y+1);
		
		System.out.println(sb);
	}
}
