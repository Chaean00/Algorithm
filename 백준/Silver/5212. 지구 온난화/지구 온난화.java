import java.util.*;
import java.io.*;
class Xy {
	int x, y;
	
	Xy (int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static char[][] map;
	static int R, C;
	static List<Xy> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		list = new ArrayList<>();
		int maxX = -1;
		int maxY = -1;
		int minX = 11;
		int minY = 11;
		
		// 2차원 배열 초기
		for (int i=0; i<R; i++) {
			String str = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		// 3면 or 4면이 바다인 지역의 좌표 구해서 list에 담
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				afterYear(i ,j);
			}
		}
		
		// list에 담긴 좌표 바다로 표
		for (int i=0; i<list.size(); i++) {
			map[list.get(i).x][list.get(i).y] = '.';
		}
		
		// 가장 작은 직사각형을 만들기 위해 좌표 구하
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j] == 'X') {
					maxX = Math.max(maxX, i);
					minX = Math.min(minX, i);
					maxY = Math.max(maxY, j);
					minY = Math.min(minY, j);
				}
			}
		}
		
		for (int i=minX; i<=maxX; i++) {
			for (int j=minY; j<=maxY; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
 		
		System.out.println(sb);
		
	}
	
	public static void afterYear(int x, int y) {
		int count = 0;
		
		for (int d=0; d<4; d++) {
			int mx = x + dx[d];
			int my = y + dy[d];
			
			if (mx < 0 || mx >= R || my < 0 || my >= C || map[mx][my] == '.') {
				count++;
				continue;
			}
		}
		
		if (count >= 3) {
			list.add(new Xy(x, y));
		}
	}
}
