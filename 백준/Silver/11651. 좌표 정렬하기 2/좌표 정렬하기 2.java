// BOJ - 11651
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[][] point = new int[N][2];
        
        for (int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	point[i][0] = Integer.parseInt(st.nextToken());
        	point[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(point, (a, b) -> {
        	if (a[1] == b[1]) {
        		return a[0] - b[0];
        	}
        	
        	return a[1] - b[1];
        });
        
        for (int i=0; i<N; i++) {
        	sb.append(point[i][0]).append(" ");
        	sb.append(point[i][1]).append("\n");
        }
        
        System.out.println(sb);
        
    }
}
