import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int N = Integer.parseInt(br.readLine());
		
		int maxTime = 48 * 60;
		
		int aPoint = 0;
		int aTime = 0;
		
		int bPoint = 0;
		int bTime = 0;
		
		int preTime = 0;
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int teamNum = Integer.parseInt(st.nextToken());
			
			int curTime = convertToTime(st.nextToken());
			
		
			if (aPoint > bPoint) { // a팀 승리 중
				aTime += curTime - preTime;
			} else if (aPoint < bPoint) { // b팀 승리 중 
				bTime += curTime - preTime;
			}
			
			
			if (teamNum == 1) aPoint += 1;
			else bPoint += 1;
			
			preTime = curTime;
		}
		
		maxTime -= preTime;
		
		if (aPoint > bPoint) aTime += maxTime;
		if (aPoint < bPoint) bTime += maxTime;
		
		System.out.println(convertToString(aTime));
		System.out.println(convertToString(bTime));
		
	}
	
	public static int convertToTime(String ms) {
		String[] msSplit = ms.split(":");
		
		return Integer.parseInt(msSplit[0]) * 60 + Integer.parseInt(msSplit[1]);
	}
	
	public static String convertToString(int ms) {
	    int m = ms / 60;
	    int s = ms % 60;

	    return String.format("%02d:%02d", m, s);
	}
}
