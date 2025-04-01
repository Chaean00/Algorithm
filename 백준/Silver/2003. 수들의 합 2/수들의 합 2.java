import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		int count =0;
		
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i=0; i<N; i++) {
			int value = 0;
			
			for (int j=i; j<N; j++) {
				value += arr[j];
				
				if (value == M) {
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
		
	}
}
