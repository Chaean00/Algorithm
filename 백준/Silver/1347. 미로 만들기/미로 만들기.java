import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[101][101];
		
		// 남 서 북 동
		// 0  1 2 3
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		int dir = 0;
		
		int x = 50;
		int y = 50;
		
		// 1은 .
		map[x][y] = 1;
		String cmd = br.readLine();
			
		for (char ch : cmd.toCharArray()) {
			if (ch == 'F') {
				x += dx[dir];
				y += dy[dir];
				
				map[x][y] = 1;
			} else if (ch == 'L') {
				dir = (dir + 3) % 4;
			} else if (ch == 'R') {
				dir = (dir + 1) % 4;
			}
		}
		
		
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		
		for (int i=0; i<101; i++) {
			for (int j=0; j<101; j++) {
				if (map[i][j] == 1) {
					minX = Math.min(minX, i);
					minY = Math.min(minY, j);
					maxX = Math.max(maxX, i);
					maxY = Math.max(maxY, j);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=minX; i<=maxX; i++) {
			for (int j=minY; j<=maxY; j++) {
				if (map[i][j] == 1) {
					sb.append(".");
				} else {
					sb.append("#");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	} 
}
