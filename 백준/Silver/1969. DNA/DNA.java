import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		String answer = "";
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] DNA = new String[N];
		
		int distance = 0;
		int max = 0;
		int idx = -1;
		
		// 입력받은 문자열 저
		for (int i=0; i<N; i++) {
			DNA[i] = sc.nextLine();
		}
		
		// i : 몇번째 글자를 의
		for (int i=0; i<M; i++) {
			// A, C, G, T 순서 (오름차순)
			int[] count = new int[4];
			
			// j : 몇번 째 문자열을 의
			for (int j=0; j<N; j++) {
				char ch = DNA[j].charAt(i);
				
				if (ch == 'A') {
					count[0]++;
				} else if (ch == 'C') {
					count[1]++;
				} else if (ch == 'G') {
					count[2]++;
				} else if (ch == 'T') {
					count[3]++;
				}	
			}
			
			for (int k=3; k>=0; k--) {
				if (count[k] >= max) {
					idx = k;
					max = count[k];
				}
			}
			
			if (idx == 0) {
				answer += "A";
			} else if (idx == 1) {
				answer += "C";
			} else if (idx == 2) {
				answer += "G";
			} else if (idx == 3) {
				answer += "T";
			}
			idx = 0;
			max = 0;
			
			for (int h=0; h<N; h++) {
				if (answer.charAt(i) != DNA[h].charAt(i)) {
					distance++;
				}
			}
		}
		
		System.out.println(answer);
		System.out.println(distance);
	}
}