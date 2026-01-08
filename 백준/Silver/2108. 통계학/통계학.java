// BOJ - 2108
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        double sum = 0;
        int[] num = new int[N];
        Map<Integer, Integer> countMap = new HashMap<>();
        int mode = 0;
        int maxCount = 0;
        
        // 산술평균 = 합 / N
        // 중강값 = 나누기 N + 1
        // 최빈값 = 반복
        // 범위 = [0] - [N-1]
        
        for (int i=0; i<N; i++) {
        	int value = Integer.parseInt(br.readLine()); 
        	num[i] = value;
        	sum += value;
        	
        	int count = countMap.getOrDefault(value, 0) + 1;
            countMap.put(value, count);
            maxCount = Math.max(maxCount, count);
        }
        
        List<Integer> candidates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                candidates.add(entry.getKey());
            }
        }
        
        Collections.sort(candidates);
        Arrays.sort(num);
        
        System.out.println((int) Math.round(sum/N));
        System.out.println(num[(N / 2)]);
        System.out.println(candidates.size() > 1 ? candidates.get(1) : candidates.get(0));
        System.out.println(num[N-1] - num[0]);
        
        
    }
}
