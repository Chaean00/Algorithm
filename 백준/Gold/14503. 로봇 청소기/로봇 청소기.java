// BOJ - 14503
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /**
         * 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
            - 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
            - 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
            - 반시계 방향으로 90도 회전한다.
            - 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
            - 1번으로 돌아간다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] DX = {-1, 0, 1, 0};
        int[] DY = {0, -1, 0, 1};

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        boolean[][] visit = new boolean[N][M];

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        // 0 - 북, 1 - 동, 2 - 남, 3 - 서
        int dir = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        while (true) {
            if (arr[x][y] == 0) {
                // 청소되지 않은 칸 청소
                arr[x][y] = 2;
                count++;
                visit[x][y] = true;
            }

            boolean isBlank = false;
            boolean isMove = false;

            for (int d=0; d<4; d++) {
                int nx = x + DX[d];
                int ny = y + DY[d];

                if (nx >= N || ny >= M || nx < 0 || ny < 0) continue;
                if (visit[nx][ny] || arr[nx][ny] == 1) continue;

                // 빈칸이 있는 경우 먼저 처리
                if (arr[nx][ny] == 0) {
                    isBlank = true;

                    dir -= 1; // 반시계 회전
                    if (dir < 0) {
                        dir = 3;
                    }

                    if (dir == 0) { // 북쪽
                        if (x-1 < N && x-1 >= 0) {
                            if (arr[x-1][y] == 0) {
                                x -= 1;
                                isMove = true;
                            }
                        }
                    } else if (dir == 1) { // 동쪽
                        if (y+1 < M && y+1 >= 0) {
                            if (arr[x][y+1] == 0) {
                                y += 1;
                                isMove = true;
                            }
                        }
                    } else if (dir == 2) { // 남쪽
                        if (x+1 < N && x+1 >= 0) {
                            if (arr[x+1][y] == 0) {
                                x += 1;
                                isMove = true;
                            }
                        }
                    } else if (dir == 3) { // 서쪽
                        if (y-1 < M && y-1 >= 0) {
                            if (arr[x][y-1] == 0) {
                                y -= 1;
                                isMove = true;
                            }
                        }
                    }

                    if (isMove) break;
                }
            } 

            boolean isWall = false;

            if (!isBlank) {
                if (dir == 0) { // 북쪽 후진
                    if (x+1 < N && x+1 >= 0) {
                        if (arr[x+1][y] == 1) {
                            break;
                        }
                        x += 1;
                        continue;
                    }
                } else if (dir == 1) { // 동쪽 후진
                    if (y-1 < M && y-1 >= 0) {
                        if (arr[x][y-1] == 1) {
                            break;
                        }
                        y -= 1;
                        continue;
                    }
                } else if (dir == 2) { // 남쪽 후진
                    if (x-1 < N && x-1 >= 0) {
                        if (arr[x-1][y] == 1) {
                            break;
                        }
                        x -= 1;
                        continue;
                    }
                } else if (dir == 3) { // 서쪽 후진
                    if (y+1 < M && y+1 >= 0) {
                        if (arr[x][y+1] == 1) {
                            break;
                            
                        }
                        y += 1;
                        continue;
                    }
                }
            }

            if (isWall) {
                break;
            }
        }

        System.out.println(count);
    }
}
