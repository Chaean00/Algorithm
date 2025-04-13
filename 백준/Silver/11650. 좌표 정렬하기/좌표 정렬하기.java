import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][2];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map, (a,b) -> {
			if (a[0] != b[0]) {
				return Integer.compare(a[0], b[0]);
			}
			
			return Integer.compare(a[1], b[1]);
		});
		
		for (int i=0; i<N; i++) {
			sb.append(map[i][0]).append(" ").append(map[i][1]).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
