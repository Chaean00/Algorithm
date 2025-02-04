import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<String, Double> map = new HashMap<>();
		String input = "";
		int count = 0;
		
		while((input = br.readLine()) != null && !input.isEmpty()) {
			count++;
			map.put(input, map.getOrDefault(input, 0.0) + 1);
		}
		
		List<String> words = new ArrayList<>(map.keySet());
		Collections.sort(words);
		
		for (int i=0; i<map.size(); i++) {
			String word = words.get(i);
			double per = map.get(word) / count * 100.0;
			per = Math.round(per * 10000.0) / 10000.0;
			sb.append(word).append(" ").append(String.format("%.4f", per)).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
