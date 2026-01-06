// BOJ - 10814

import java.io.*;
import java.util.*;


class Member {
	int age;
	String name;
	
	public Member(int age, String name) {
		this.age = age;
		this.name = name;
	}
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        List<Member> members = new ArrayList<>();
        
        for (int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int age = Integer.parseInt(st.nextToken());
        	String name = st.nextToken();
        	
        	members.add(new Member(age, name));
        }
        
        Collections.sort(members, (a, b) -> a.age - b.age);
        
        
        for (int i=0; i<N; i++) {
        	Member member = members.get(i);
        	sb.append(member.age).append(" ");
        	sb.append(member.name).append("\n");
        }
        
        System.out.println(sb);
    }
}
