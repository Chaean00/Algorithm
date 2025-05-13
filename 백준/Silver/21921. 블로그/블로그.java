import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] visit = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			visit[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for (int i=0; i<X; i++) {
			sum += visit[i];
		}
		
		int max = sum;
		int count = 1;
		
		for (int i=X; i<N; i++) {
			sum = sum - visit[i - X] + visit[i];
			
			if (sum > max) {
				max = sum;
				count = 1;
			} else if (sum == max) {
				count++;
			}
		}
		
		if (max == 0) System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(count);
		}
	} 
}
