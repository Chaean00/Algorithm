import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			
			long max = Integer.MIN_VALUE;
			long maxSoldier = -1;
			
			Map<Long, Long> land = new HashMap<>();
			
			for (int j=0; j<t; j++) {
				long soldier = Long.parseLong(st.nextToken());
				
				land.put(soldier, land.getOrDefault(soldier, 0L) + 1);
				
				if (land.get(soldier) > max) {
					max = Math.max(max, land.get(soldier));
					maxSoldier = soldier;
				}
			}
			
			if (max > t / 2) {
				System.out.println(maxSoldier);
			} else {
				System.out.println("SYJKGW");
			}
		}
	} 
}
