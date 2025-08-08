// BOJ - 20291
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<N; i++) {
            String ex = br.readLine().split("\\.")[1];

            map.put(ex, map.getOrDefault(ex, 0) + 1);
        }
        
        String[] arr = new String[map.size()];

        int i=0;
        for (String key : map.keySet()) {
            arr[i] = key;
            i++;
        }

        Arrays.sort(arr, (a1, b1) -> a1.compareTo(b1));

        for (String name : arr) {
            sb.append(name).append(" ").append(map.get(name)).append("\n");
        }

        System.out.println(sb);
    }
}
