import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		
		int[][] arr = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		int[][] fil = new int[3][3];
		
		for (int i=0; i<N-2; i++) {
			for (int j=0; j<M-2; j++) {
				count += centerNumber(i, j, arr, T);
			}
		}
		/*
		 * i = 0~4 , N = 6
		 * j = 0~3 , M = 5
		 */
		
		System.out.println(count);
	}
	
	public static int centerNumber(int x, int y, int[][] arr, int t) {
		List<Integer> list = new ArrayList<>();
		
		for (int i=x; i<=x+2; i++) {
			for (int j=y; j<=y+2; j++) {
				list.add(arr[i][j]);
			}
		}
		
		Collections.sort(list);
		
		if (list.get(4) >= t) {
			return 1;
		} else {
			return 0;
		}
	}
}
