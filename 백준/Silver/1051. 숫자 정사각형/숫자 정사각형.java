import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int side = Math.min(N, M) - 1;
		
		int[][] map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}
		
		while(side >= 1) {
			
			for (int i=0; i<N-side; i++) {
				for (int j=0; j<M-side; j++) {
					
					int lt = map[i][j];
					int rt = map[i][j+side];
					int lb = map[i+side][j];
					int rb = map[i+side][j+side];
					
					if (lt == rt && rt == lb && lb == rb && lt == rb) {
						System.out.println((side+1)*(side+1));
						return;
					}
					
				}
			}
			
			side--;
		}
		
		System.out.println(1);
	} 
}
