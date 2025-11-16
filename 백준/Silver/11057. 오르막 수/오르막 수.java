// BOJ - 11057
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];
        
        for (int i=0; i<=9; i++) {
        	dp[1][i] = 1;
        }
        
        for (int i=2; i<=N; i++) {
        	for (int j=0; j<=9; j++) {
        		int count = 0;
        		for (int k=j; k<=9; k++) {
        			count += dp[i-1][k];
        			if (count >= 10007) {
        				count -= 10007;
        			}
        		}
        		dp[i][j] = count;
        	}
        }
        
        int answer = 0;
        for (int i=0; i<=9; i++) {
        	answer += dp[N][i];
            if (answer >= 10007) {
                answer -= 10007;
            }
        }
        
        System.out.println(answer);
    }
}
