// BOJ - 2659
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] numbers = br.readLine().split(" ");
        
        // 시계 수  
        int number = solveNumber(numbers);
        
        int count = 0;
        for (int i=1111; i<=number; i++) {
        	if (isSolve(i)) {
        		count++;
        	}
        }
        
        System.out.println(count);
    }
    
    public static int solveNumber(String[] arr) {
    	int number = Integer.MAX_VALUE;
        
        for (int i=0; i<4; i++) {
        	String temp = arr[i];
        	for (int j=0; j<3; j++) {
        		int idx = (j + i + 1) % 4;
        		temp += arr[idx];
        	}
        	
        	number = Math.min(number, Integer.parseInt(temp));
        }
        
        return number;
    }
    
    public static boolean isSolve(int value) {
    	char[] arr = (value + "").toCharArray();
    	
    	int number = Integer.MAX_VALUE;
        
        for (int i=0; i<4; i++) {
        	String temp = arr[i] + "";
        	for (int j=0; j<3; j++) {
        		int idx = (j + i + 1) % 4;
        		temp += arr[idx];
        	}
        	
        	number = Math.min(number, Integer.parseInt(temp));
        }
        
        if (value == number) {
        	return true;
        }
    	
        return false;
    }
}
