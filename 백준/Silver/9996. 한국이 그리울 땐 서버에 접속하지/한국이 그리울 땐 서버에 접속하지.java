import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(sc.nextLine());
		String[] pattern = sc.nextLine().split("\\*");
		
		for (int i=0; i<N; i++) {
			String str = sc.nextLine();
			
			if (str.startsWith(pattern[0])) {
				str = str.substring(pattern[0].length(), str.length());
				if (str.endsWith(pattern[1])) {
					sb.append("DA").append("\n");
				} else {
					sb.append("NE").append("\n");
				}
			} else {
				sb.append("NE").append("\n");
			}
		}
		
		System.out.println(sb);
	}
}