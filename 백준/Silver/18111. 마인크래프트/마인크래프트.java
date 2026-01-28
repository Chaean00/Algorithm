// BOJ - 18111
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        int answerTime = Integer.MAX_VALUE;
        int answerHeight = Integer.MIN_VALUE;
        
        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }

        for (int h=0; h<=256; h++) {
        	int time = 0;
        	int diff = 0;
        	int block = B;
        	for (int i=0; i<N; i++) {
        		for (int j=0; j<M; j++) {
        			int height = map[i][j];
        			
        			diff = height - h;
        			
        			if (diff == 0) continue;
        			// 블록 제거 
        			if (diff > 0) {
        				time += diff * 2;
        				block += diff;
        			}
        			// 블록 추가
        			if (diff < 0) {
        				time += Math.abs(diff);
        				block -= Math.abs(diff);
        			}
        		}
        	}
        	
        	if (block < 0) continue;
        	
        	if (answerTime == time && answerHeight < h) {
        		answerTime = time;
        		answerHeight = h;
        	}
        	else if (answerTime > time) {
        		answerTime = time;
        		answerHeight = h;
        	}
        }
        
        System.out.println(answerTime + " " + answerHeight);
    }
}
