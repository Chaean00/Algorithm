// BOJ - 10825
import java.io.*;
import java.util.*;

class Student {
	String name;
	int korean;
	int english;
	int math;
	
	public Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();
        
        for (int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	String name = st.nextToken();
        	int korean = Integer.parseInt(st.nextToken());
        	int english = Integer.parseInt(st.nextToken());
        	int math = Integer.parseInt(st.nextToken());
        	
        	students.add(new Student(name, korean, english, math));
        }
        
        Collections.sort(students, (a, b) -> {
    		if (a.korean == b.korean && a.english == b.english && a.math == b.math) {
    			return a.name.compareTo(b.name);
    		}
    		
    		if (a.korean == b.korean && a.english == b.english) {
    			return b.math - a.math;
    		}
    		
    		if (a.korean == b.korean) {
    			return a.english - b.english;
    		}
    		
    		return b.korean - a.korean; 
    	});
        
        for (int i=0; i<N; i++) {
    		System.out.println(students.get(i).name);
    	}
    }
}
