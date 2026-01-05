// BOJ - 2751

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Set<Integer> numbers = new TreeSet<>();
        
        for (int i=0; i<N; i++) {
        	numbers.add(Integer.parseInt(br.readLine()));
        }
        
        for (Integer num : numbers) {
        	sb.append(num).append("\n");
        }
        
        System.out.println(sb);
    }
}
