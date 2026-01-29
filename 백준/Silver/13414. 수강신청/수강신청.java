// BOJ - 13414
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int possible = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
//        List<String> students = new ArrayList<>();
        Map<String, Integer> students = new LinkedHashMap<>();
        
        for (int i=0; i<L; i++) {
        	String student = br.readLine();
        	
        	if (students.containsKey(student)) {
        		students.remove(student);
        		students.put(student, 1);
        	} else {
        		students.put(student, 1);
        	}
        }
        
        int count = 0;
        for(Map.Entry<String, Integer> student : students.entrySet()) {
        	if (count >= possible) break;
        	System.out.println(student.getKey());
        	count++;
        }
    }
}
