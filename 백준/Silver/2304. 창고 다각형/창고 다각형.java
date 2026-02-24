import java.io.*;
import java.util.*;

public class Main {

    static class Pillar {
        int pos;
        int height;

        Pillar(int pos, int height) {
            this.pos = pos;
            this.height = height;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Pillar[] pillars = new Pillar[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pillars[i] = new Pillar(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        Arrays.sort(pillars, Comparator.comparingInt(p -> p.pos));

        int maxHeight = 0;
        for (Pillar p : pillars) {
            maxHeight = Math.max(maxHeight, p.height);
        }

        int firstMax = -1;
        int lastMax = -1;

        for (int i = 0; i < N; i++) {
            if (pillars[i].height == maxHeight) {
                if (firstMax == -1) {
                    firstMax = i;
                }
                lastMax = i;
            }
        }

        int area = 0;

        int leftMax = pillars[0].height;
        int leftPos = pillars[0].pos;

        for (int i = 1; i <= firstMax; i++) {
            if (pillars[i].height >= leftMax) {
                area += leftMax * (pillars[i].pos - leftPos);
                leftMax = pillars[i].height;
                leftPos = pillars[i].pos;
            }
        }

        int rightMax = pillars[N - 1].height;
        int rightPos = pillars[N - 1].pos;

        for (int i = N - 2; i >= lastMax; i--) {
            if (pillars[i].height >= rightMax) {
                area += rightMax * (rightPos - pillars[i].pos);
                rightMax = pillars[i].height;
                rightPos = pillars[i].pos;
            }
        }
        
        int width = pillars[lastMax].pos - pillars[firstMax].pos + 1;
        area += maxHeight * width;

        System.out.println(area);
    }
}