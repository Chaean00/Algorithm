import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> cows = new HashMap<>();
		int count = 0;
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int cowNum = Integer.parseInt(st.nextToken());
			int move = Integer.parseInt(st.nextToken());
			
			if(cows.containsKey(cowNum)) {
				if (cows.get(cowNum) != move) {
					cows.put(cowNum, move);
					count++;
				}
			} else {
				cows.put(cowNum, move);
			}
		}
		
		System.out.println(count);
	}
}
