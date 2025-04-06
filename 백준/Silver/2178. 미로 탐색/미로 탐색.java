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
    static int N, M; // x, y
    static int[] dx = {1,0,-1,0}; // x 이동 값
    static int[] dy = {0,1,0,-1}; // y 이동 값
    static int[][] maze; // 미로를 담을 2차원 배열
    static boolean[][] visit; // 방문 흔적을 남길 2차원 배열

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visit = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<M; j++) {
                maze[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (maze[i][j] == 1 && !visit[i][j]) {
                    BFS(i, j);
                }
            }
        }

        System.out.println(maze[N-1][M-1]);
    }

    public static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        visit[x][y] = true;

        while (!Q.isEmpty()) {
            Point point = Q.poll();
            for (int d=0; d<4; d++) {
                int p_x = point.x + dx[d];
                int p_y = point.y + dy[d];

                if (p_x < 0 || p_x >= N || p_y < 0 || p_y >= M) continue;
                if (visit[p_x][p_y] || maze[p_x][p_y] == 0) continue;

                Q.offer(new Point(p_x, p_y));
                maze[p_x][p_y] = maze[point.x][point.y] + 1;
                visit[p_x][p_y] = true;
            }
        }
    }
}
