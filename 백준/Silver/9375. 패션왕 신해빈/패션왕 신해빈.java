import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			int M = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			int result = 1;
			
			for (int j=0; j<M; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				st.nextToken();
				String value = st.nextToken();
				
				map.put(value, map.getOrDefault(value, 1) + 1);
			}
			
			for (Integer value : map.values()) {
				result *= value;
			}
			
			System.out.println(result - 1);
		}
	}
}