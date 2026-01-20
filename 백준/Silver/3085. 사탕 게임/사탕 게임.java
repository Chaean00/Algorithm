// BOJ - 3085
import java.io.*;
import java.util.*;
public class Main {
	static int N;	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        int answer = 0;
        
        char[][] map = new char[N][N];
        
    	for (int i=0; i<N; i++) {
    		String str = br.readLine();
    		for (int j=0; j<N; j++) {
    			char c = str.charAt(j);
    			map[i][j] = c;
    		}
    	}
    	
    	int[] dx = {-1, 0, 1, 0};
    	int[] dy = {0, -1, 0, 1};
    	
    	for (int i=0; i<N; i++) {
    		for (int j=0; j<N; j++) {
    			
    			char current = map[i][j];
    			
    			for (int d=0; d<4; d++) {
    				
    				int moveI = dx[d] + i;
    				int moveJ = dy[d] + j;
    				
    				if (moveI >= N || moveI < 0 || moveJ >= N || moveJ < 0) continue;
    				
    				char temp = map[i][j];
    				map[i][j] = map[moveI][moveJ];
    				map[moveI][moveJ] = temp;
    				
    				answer = Math.max(answer, search(map));
    				
    				temp = map[i][j];
    				map[i][j] = map[moveI][moveJ];
    				map[moveI][moveJ] = temp;
    				
    				if (answer == N) {
    					System.out.println(answer);
    					return;
    				}
    				
    			}
    			
    		}
    	}
    	
    	System.out.println(answer);
    }
    
    public static int search(char[][] map) {
    	
    	int max = 0;
    	
    	for (int i=0; i<N; i++) {
    		int count = 1;
    		
    		for (int j=0; j<N-1; j++) {
    			if(map[i][j] == map[i][j+1]) {
    				count++;
    			} else {
    				count = 1;
    			}
    			max = Math.max(max, count);
    		}
    	}
    	
    	for (int i=0; i<N; i++) {
    		int count = 1;
    		
    		for (int j=0; j<N-1; j++) {
    			if(map[j][i] == map[j+1][i]) {
    				count++;
    			} else {
    				count = 1;
    			}
    			max = Math.max(max, count);
    		}
    	}
    	
    	
    	return max;
    }
    
    
}
