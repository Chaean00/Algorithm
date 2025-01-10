import java.io.*;
import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M, day;
    static int[][] tomato;
    static Queue<Point> queue;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];
        queue = new LinkedList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        System.out.println(BFS());

    }

    public static int BFS() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int d=0; d<4; d++) {
                int p_x = point.x + dx[d];
                int p_y = point.y + dy[d];

                if (p_x < 0 || p_x >= N || p_y < 0 || p_y >= M) continue;
                if (tomato[p_x][p_y] == 0) {
                    queue.offer(new Point(p_x, p_y));
                    tomato[p_x][p_y] = tomato[point.x][point.y] + 1;
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (tomato[i][j] == 0) {
                    return -1;
                }
                day = Math.max(day, tomato[i][j]);
            }
        }
        return day-1;
    }

}
