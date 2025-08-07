import java.util.*;
import java.io.*;

class Player{
	int level;
	String name;
	
	public Player(int l, String n) {
		this.level = l;
		this.name = n;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<Player>> list = new ArrayList<>();
		
		for (int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			
			int level = Integer.parseInt(st.nextToken());
			String id = st.nextToken();
			
			if (list.isEmpty()) {
				List<Player> room = new ArrayList<>();
				Player player = new Player(level, id);
				
				room.add(player);
				
				list.add(room);
				continue;
			}
			
			boolean enter = false;
			
			for (int j=0; j<list.size(); j++) {
				int startLevel = list.get(j).get(0).level;
				
				Player player = new Player(level, id);
				
				if (level <= startLevel + 10 && level >= startLevel - 10 && list.get(j).size() < m) {
					
					list.get(j).add(player);
					enter = true;
					break;
				} else {
					
				}
			}
			
			if (!enter) {
				Player player = new Player(level, id);
				List<Player> room = new ArrayList<>();
				
				room.add(player);
				
				list.add(room);
			}
		}
		
		for (List<Player> room : list) {
			if (room.size() < m) {
				sb.append("Waiting!").append("\n");
			} else {
				sb.append("Started!").append("\n");
			}
			
			room.sort((a, b) -> a.name.compareTo(b.name));
			
			for (Player player : room) {
				sb.append(player.level).append(" ").append(player.name).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
}
