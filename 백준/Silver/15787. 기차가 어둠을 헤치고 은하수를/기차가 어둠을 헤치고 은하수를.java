import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 기차 수
        int M = sc.nextInt(); // 명령 수

        boolean[][] train = new boolean[N + 1][21]; // 1-based indexing
        HashSet<String> set = new HashSet<>(); // 중복된 상태 제거를 위한 HashSet

        for (int i = 0; i < M; i++) {
            int command = sc.nextInt(); // 명령어
            int number = sc.nextInt(); // 기차 번호

            if (command == 1) {
                int seat = sc.nextInt();
                train[number][seat] = true; // 좌석에 사람 태우기
            } else if (command == 2) {
                int seat = sc.nextInt();
                train[number][seat] = false; // 좌석에 사람 하차
            } else if (command == 3) {
                // 뒤로 밀기
                for (int j = 20; j > 1; j--) {
                    train[number][j] = train[number][j - 1];
                }
                train[number][1] = false; // 맨 앞 좌석 비우기
            } else if (command == 4) {
                // 앞으로 당기기
                for (int j = 1; j < 20; j++) {
                    train[number][j] = train[number][j + 1];
                }
                train[number][20] = false; // 맨 뒤 좌석 비우기
            }
        }

        // 기차 상태를 문자열로 변환하여 HashSet에 저장
        for (int i = 1; i <= N; i++) {
            StringBuilder trainState = new StringBuilder();
            for (int j = 1; j <= 20; j++) {
                trainState.append(train[i][j] ? "1" : "0");
            }
            set.add(trainState.toString());
        }

        System.out.println(set.size()); // 서로 다른 기차 상태의 개수 출력
    }
}