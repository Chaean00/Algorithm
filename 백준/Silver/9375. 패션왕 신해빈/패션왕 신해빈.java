import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			Map<String, Integer> map = new HashMap<>();
			int M = Integer.parseInt(br.readLine());
			
			for (int j=0; j<M; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();
				
				map.put(type, map.getOrDefault(type, 1) + 1);
			}
			
			int answer = 1;
			
			for (int value : map.values()) {
				answer *= value;
			}
			
			System.out.println(answer-1);
		}
		
		
	}
}
