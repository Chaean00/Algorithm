// BOJ - 10814
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[][] users = new String[N][2];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            users[i][0] = st.nextToken();
            users[i][1] = st.nextToken();
        }

        Arrays.sort(users, (a1, b1) -> {
            return Integer.parseInt(a1[0]) - Integer.parseInt(b1[0]);
        });

        for (int i=0; i<N; i++) {
            System.out.println(users[i][0] + " " + users[i][1]);
        }
    }
}
