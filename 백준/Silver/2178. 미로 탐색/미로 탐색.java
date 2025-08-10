// BOJ - 2178
import java.util.*;
import java.io.*;
class Point {
    int x,y;

    Point(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M;
    static int[][] arr;
    static int[] DX = {-1, 0, 1, 0};
    static int[] DY = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<M; j++) {
                char c = str.charAt(j);
                arr[i][j] = Integer.parseInt(c + "");
            }
        }

        System.out.println(bfs());
    }

    static public int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == N-1 && p.y == M -1) return arr[p.x][p.y];

            for (int d=0; d<4; d++) {
                int nx = p.x + DX[d];
                int ny = p.y + DY[d];

                if (nx >= N || nx < 0 || ny >= M || ny < 0) continue;
                if (arr[nx][ny] != 1) continue;

                arr[nx][ny] = arr[p.x][p.y] + 1;
                q.offer(new Point(nx, ny));
            }
        }

        return -1;
    }
}
