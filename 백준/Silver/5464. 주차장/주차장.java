// BOJ - 5464
import java.io.*;
import java.util.*;

class Parking {
	int carNum = -1;
	int price;
	
	Parking(int price) {
		this.price = price;
	}
	
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
         
        Parking[] parkings = new Parking[N];
        int[] carWeight = new int[M];
        Queue<Integer> q = new LinkedList<>();
        
        int total = 0;
        
        // 무게 당 요금
        for (int i=0; i<N; i++) {
        	parkings[i] = new Parking(Integer.parseInt(br.readLine()));
        }
        // 차량의 무게
        for (int i=0; i<M; i++) {
        	carWeight[i] = Integer.parseInt(br.readLine());
        }
        
        // 차량 출입 순서 
        for (int i=0; i<M*2; i++) {
        	int carNum = Integer.parseInt(br.readLine());
        	
        	// 차량 들어올 때 
        	if (carNum > 0) {
        		for (int j=0; j<N; j++) {
            		Parking temp = parkings[j];
            		
            		if (temp.carNum == -1) {
            			temp.setCarNum(carNum);
            			break;
            		} else if (j == N - 1) {
            			q.offer(carNum);
            		}
            	}
        	}
        	
        	// 차량 나갈 때 
        	if (carNum < 0) {
        		for (int j=0; j<N; j++) {
        			Parking temp = parkings[j];
        			if (temp.carNum == Math.abs(carNum)) {
        				// 가격 정산 
        				total += carWeight[temp.carNum-1] * temp.price;
        				
        				temp.setCarNum(-1);
        				
        				// 대기 중인 차량 들어오기
        				if (!q.isEmpty()) {
        					temp.setCarNum(q.poll());
        				}
        				
        				break;
        			}
        		}
        	}
        }
        
        System.out.println(total);
    }
}
