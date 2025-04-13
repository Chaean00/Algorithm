import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});
		
		int cnt = 0;
		int end = 0;
		
		for (int i=0; i<N; i++) {
			if (time[i][0] >= end) {
				cnt++;
				end = time[i][1];
			}
		}
		
		System.out.println(cnt);
		
	}
}
