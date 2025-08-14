// BOJ - 14890
import java.util.*;
import java.io.*;

// 한 행씩 검사하는 함수로 다시 풀어보기.
public class Main {
    static int N, L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가로 방향
        for (int[] road : arr) {
            if (isRoad(road)) count++;
        }

        // 세로 방향
        for (int i=0; i<N; i++) {
            int[] row = new int[N];
            for (int j=0; j<N; j++) {
                row[j] = arr[j][i];
            }
            if (isRoad(row)) count++;
        }

        System.out.println(count);
    }

    public static boolean isRoad(int[] road) {
        boolean[] visit = new boolean[road.length];

        for (int i=0; i<N-1; i++) {
            int diff = road[i] - road[i+1];
            if (diff == 0) continue; // 높이가 같은 경우
            if (Math.abs(diff) > 1) return false; // 높이 차이가 2이상인 경우

            // 높이 차이가 1인경우 - 경사로 놓을 수 있는지 체크
            if (road[i] < road[i+1]) {
                if (i-L+1 < 0) return false; // 맵 밖인 경우

                for (int h=i-L+1; h<=i; h++) {
                    if (road[h] != road[i] || visit[h]) return false; // 경사로를 놓을 수 없는 경우
                }
            } else if (road[i] > road[i+1]) {
                if (i+L >= N) return false; // 맵 밖인 경우

                for (int h=i+1; h<=i+L; h++) {
                    if (road[h] != road[i+1] || visit[h]) return false;
                }
            }

            // 경사로 놓기
            if (road[i] < road[i+1]) { // 오르막
                for (int h=i-L+1; h<=i; h++) {
                    visit[h] = true;
                }
            } else if (road[i] > road[i+1]) { // 내리막
                for (int h=i+1; h<=i+L; h++) {
                    visit[h] = true;
                }
                i += L-1;
            }
            
        }

        return true;
    }
}
