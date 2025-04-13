import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] x = new int[N];
		
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int value = Integer.parseInt(st.nextToken()); 
			x[i] = value;
			set.add(value);
		}
		
		List<Integer> index = new ArrayList<>(set);
		
		Collections.sort(index);
		
		for (int i=0; i<index.size(); i++) {
			map.put(index.get(i), i);
		}
		
		for (int i=0; i<N; i++) {
			sb.append(map.get(x[i])).append(" ");
		}
		
		System.out.println(sb);
		
	}
}
