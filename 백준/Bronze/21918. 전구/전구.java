import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] light = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			light[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				light[b] = c;
			}
			if (a == 2) {
				for (int j=b; j<=c; j++) {
					if (light[j] == 1) light[j] = 0;
					else light[j] = 1;
				}
			}
			if (a == 3) {
				for (int j=b; j<=c; j++) {
					light[j] = 0;
				}
			}
			if (a == 4) {
				for (int j=b; j<=c; j++) {
					light[j] = 1;
				}
			}
		}
		
		for (int i=1; i<=N; i++) {
			System.out.print(light[i] + " ");
		}
		
		
	}
}
