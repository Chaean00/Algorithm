// BOJ - 2667
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
    static int N;
    static int[][] arr;
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();
    static int[] DX = {-1, 0, 1, 0};
    static int[] DY = {0, 1, 0, -1};
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit=  new boolean[N][N];

        for (int i=0; i<N; i++) {
            String str = br.readLine();

            for (int j=0; j<str.length(); j++) {
                char c = str.charAt(j);

                arr[i][j] = Integer.parseInt(c + "");
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for (int i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    static public void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visit[x][y] = true;

        int count = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d=0; d<4; d++) {
                int nx = p.x + DX[d];
                int ny = p.y + DY[d];

                if (nx >= N || ny >= N || nx < 0 || ny < 0) continue;
                if (visit[nx][ny] || arr[nx][ny] == 0) continue;

                visit[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
            count++;
        }

        list.add(count);
    }
}