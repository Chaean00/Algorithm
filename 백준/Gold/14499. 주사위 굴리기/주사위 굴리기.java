// BOJ - 14499
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        
        /**
         * 0 위
         * 1 아래
         * 2 북
         * 3 남
         * 4 서
         * 5 동
         */
        int[] dice = new int[6];
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        
        // 명령어 처리 
        st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<K; i++) {
        	int dir = Integer.parseInt(st.nextToken());
        	int nx = x;
        	int ny = y;
        	
        	if (dir == 1) ny = y + 1;
        	else if (dir == 2) ny = y - 1;
        	else if (dir == 3) nx = x - 1;
        	else if (dir == 4) nx = x + 1;
        	
        	if (nx >= N || ny >= M || nx < 0 || ny < 0) continue;
        	
        	rollDice(dir, dice);
        	
        	
        	if (arr[nx][ny] == 0) {
        		arr[nx][ny] = dice[1];
        	} else {
        		dice[1] = arr[nx][ny];
        		arr[nx][ny] = 0;
        	}
        	
        	x = nx;
        	y = ny;
        	sb.append(dice[0]).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void rollDice(int dir, int[] dice) {
    	int temp;
    	
    	switch(dir) {
    		// 동 
    		case 1:
    			temp = dice[5];
    			dice[5] = dice[1];
    			dice[1] = dice[4];
    			dice[4] = dice[0];
    			dice[0] = temp;
    			break;
    		// 서 
    		case 2:
    			temp = dice[4];
    			dice[4] = dice[1];
    			dice[1] = dice[5];
    			dice[5] = dice[0];
    			dice[0] = temp;
    			break;
    		// 남 
    		case 3:
    			temp = dice[3];
    			dice[3] = dice[1];
    			dice[1] = dice[2];
    			dice[2] = dice[0];
    			dice[0] = temp;
    			break;
    		// 북
    		case 4:
    			temp = dice[2];
    			dice[2] = dice[1];
    			dice[1] = dice[3];
    			dice[3] = dice[0];
    			dice[0] = temp;
    			break;
    	}
    }
}
