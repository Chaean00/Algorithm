// BOJ - 7576
import java.util.*;
import java.io.*;

class Point {
    int x, y;

    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[] DX = {-1, 0, 1, 0};
    static int[] DY = {0, -1, 0, 1};
    static Queue<Point> q = new LinkedList<>();
    static int[][] arr;
    static boolean[][] visit;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    q.offer(new Point(i, j));
                    visit[i][j] = true;
                }
            }
        }

        bfs();

        int answer = -1;

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                answer = Math.max(answer, arr[i][j]);
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer-1);

    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d=0; d<4; d++) {
                int nx = p.x + DX[d];
                int ny = p.y + DY[d];

                if (nx >= N || ny >= M || nx < 0 || ny < 0) continue;
                if (visit[nx][ny] || arr[nx][ny] == -1) continue;

                q.offer(new Point(nx, ny));
                visit[nx][ny] = true;
                arr[nx][ny] = arr[p.x][p.y] + 1;
            }
        }
    }
}
