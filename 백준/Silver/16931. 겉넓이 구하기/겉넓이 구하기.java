// BOJ - 1283
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] cube = new int[N][M];
        
        int answer = 0;
        
        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0; j<M; j++) {
        		cube[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // 위 + 아래
        answer += N * M * 2;
        
        // 왼쪽
        for (int i=0; i<N; i++) {
        	answer += cube[i][0];
        	
        	for (int j=1; j<M; j++) {
                if (cube[i][j] > cube[i][j - 1]) {
                    answer += cube[i][j] - cube[i][j - 1];
                }
        	}
        }
        
        // 오른쪽
        for (int i=0; i<N; i++) {
        	answer += cube[i][M-1];
        	
        	for (int j=M-2; j>=0; j--) {
                if (cube[i][j] > cube[i][j + 1]) {
                    answer += cube[i][j] - cube[i][j + 1];
                }
        	}
        }
        
        // 뒤
        for (int i=0; i<M; i++) {
        	answer += cube[0][i];
        	
        	for (int j=1; j<N; j++) {
        		if (cube[j][i] > cube[j-1][i]) {
        			answer += cube[j][i] - cube[j-1][i];
        		}
        	}
        }
        
        // 앞
        for (int i=0; i<M; i++) {
        	answer += cube[N-1][i];
        	
        	for (int j=N-2; j>=0; j--) {
        		if (cube[j][i] > cube[j+1][i]) {
        			answer += cube[j][i] - cube[j+1][i];
        		}
        	}
        }
        
        System.out.println(answer);
    }
}
