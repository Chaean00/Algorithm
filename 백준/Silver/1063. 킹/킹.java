// BOJ - 1063
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        String king = st.nextToken();
        String rock = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        
        int[][] chess = new int[8][8];
        
        // ex) A1 -> A = i, 1 = j
        int kingI = 8 - Integer.parseInt(king.charAt(1) + "");
        int kingJ = king.charAt(0) - 65;
        
        int rockI = 8 - Integer.parseInt(rock.charAt(1) + "");
        int rockJ = rock.charAt(0) - 65;
        
        for (int n=0; n<N; n++) {
        	String cmd = br.readLine();
        	
        	int i = 0;
        	int j = 0;
        	
        	if (cmd.equals("R")) {
        		j++;
        	} else if (cmd.equals("L")) {
        		j--;
        	} else if (cmd.equals("B")) {
        		i++;
        	} else if (cmd.equals("T")) {
        		i--;
        	} else if (cmd.equals("RT")) {
        		j++;
        		i--;
        	} else if (cmd.equals("LT")) {
        		j--;
        		i--;
        	} else if (cmd.equals("RB")) {
        		j++;
        		i++;
        	} else if (cmd.equals("LB")) {
        		j--;
        		i++;
        	}
        	
        	if (kingI + i < 0 || kingI + i >= 8 || kingJ + j < 0 || kingJ + j >= 8) {
        		continue;
        	}
        	
        	if (kingI + i == rockI && kingJ + j == rockJ) {
        		if (rockI + i < 0 || rockI + i >= 8 || rockJ + j < 0 || rockJ + j >= 8) {
        			continue;
        		} else {
        			rockI += i;
        			rockJ += j;
        		}
        	}
        	
        	kingI += i;
        	kingJ += j;
        }
        
        char kingC = (char) (kingJ + 65);
        char rockC = (char) (rockJ + 65);
        
        sb.append(kingC).append(8 - kingI).append("\n");
        sb.append(rockC).append(8 - rockI).append("\n");
        
        System.out.println(sb);
    }
}
