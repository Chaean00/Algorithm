// BOJ - 20291
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();

        for (int i=0; i<N; i++) {
            String ex = br.readLine().split("\\.")[1];

            map.put(ex, map.getOrDefault(ex, 0) + 1);
        }

        for (String key : map.keySet()) {
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }

        System.out.println(sb);
    }
}
