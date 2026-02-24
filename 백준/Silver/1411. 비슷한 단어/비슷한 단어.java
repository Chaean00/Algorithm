import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		
		for (int i=0; i<N; i++) {
			words[i] = br.readLine();
		}
		
		int count = 0;
		
		for (int i=0; i<N; i++) {
			String A = makePattern(words[i]);
			
			for (int j=i+1; j<N; j++) {
				String B = makePattern(words[j]);
				
				if (A.equals(B)) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
	
	private static String makePattern(String word) {
		Map<Character, Integer> map = new HashMap<>();
		StringBuilder p = new StringBuilder();
		
		int idx = 0;
		
		for (char ch : word.toCharArray()) {
			if (!map.containsKey(ch)) {
				map.put(ch, idx);
				idx++;
			}
			p.append(map.get(ch)).append(",");
		}
		
		return p.toString();
	}
}
