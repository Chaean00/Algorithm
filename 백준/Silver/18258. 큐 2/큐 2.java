// BOJ - 18258
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	String command = st.nextToken();
        	
        	if (command.equals("push")) {
        		deque.offerLast(Integer.parseInt(st.nextToken()));
        	} else if (command.equals("pop")) {
        		if (deque.isEmpty()) {
        			sb.append("-1").append("\n");
        		} else {
        			sb.append(deque.pollFirst()).append("\n");
        		}
        	} else if (command.equals("size")) {
        		sb.append(deque.size()).append("\n");
        	} else if (command.equals("empty")) {
        		if (deque.isEmpty()) {
        			sb.append(1).append("\n");
        		} else {
        			sb.append(0).append("\n");
        		}
        	} else if (command.equals("front")) {
        		if (deque.isEmpty()) {
        			sb.append(-1).append("\n");
        		} else {
        			sb.append(deque.peekFirst()).append("\n");
        		}
        	} else if (command.equals("back")) {
        		if (deque.isEmpty()) {
        			sb.append(-1).append("\n");
        		} else {
        			sb.append(deque.peekLast()).append("\n");
        		}
        	}
        }
        
        System.out.println(sb);
    }
}
