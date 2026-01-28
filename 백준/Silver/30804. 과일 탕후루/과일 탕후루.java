// BOJ - 30804
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] stick = new int[N];
        
        int max = Integer.MIN_VALUE;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> fruit = new HashMap<>();
        
        for (int i=0; i<N; i++) {
        	stick[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        
        for (int right=0; right<N; right++) {
        	fruit.put(stick[right], fruit.getOrDefault(stick[right], 0) + 1);
        	
        	while (fruit.size() > 2) {
        		int leftFruit = stick[left];
        		
        		int remain = fruit.get(leftFruit) - 1;
        		if (remain <= 0) {
        			fruit.remove(leftFruit);
        		} else {
        			fruit.put(leftFruit, remain);
        		}
        		
        		left++;
        	}
        	
        	max = Math.max(max, right - left + 1);
        }
        
        System.out.println(max);
    }
}
