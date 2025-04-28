import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = getTime(st.nextToken());
		int E = getTime(st.nextToken());
		int Q = getTime(st.nextToken());
		Set<String> enter = new HashSet<>();
		Set<String> exit = new HashSet<>();
		
		String str = "";
		while ( (str = br.readLine()) != null && !(str.isEmpty()) ) {
			st = new StringTokenizer(str);
			
			int time = getTime(st.nextToken());
			String name = st.nextToken();
			
			if (time <= S) {
				enter.add(name);
			} else if (time >= E && time <= Q) {
				if (enter.contains(name)) {
					exit.add(name);
				}
			}
		}
		
		System.out.println(exit.size());
		
	}
	
	public static int getTime(String time) {
		String[] stringTime = time.split(":");
		return (Integer.parseInt(stringTime[0]) * 60) + Integer.parseInt(stringTime[1]);
	}
}
