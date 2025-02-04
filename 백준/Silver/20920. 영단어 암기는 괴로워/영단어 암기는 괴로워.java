import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			
			if (str.length() < M) continue;
			
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		
		List<String> list = new ArrayList<>(map.keySet());
		
		list.sort((o1, o2) -> {
			int c1 = map.get(o1);
			int c2 = map.get(o2);
			
			if (c1 == c2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o2.length() - o1.length();
			}
			
			return c2 - c1;
		});
		
		for (int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(sb);	
	}
}
