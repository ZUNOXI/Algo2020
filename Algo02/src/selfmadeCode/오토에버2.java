package selfmadeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 오토에버2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 솔루션 함수 들어갈 배열 선언
		String [] arr = {"alex pizza pasta steak","bob noodle sandwich pasta","choi pizza sandwich pizza","alex pizza pasta steak"};
		
		
		System.out.println(Arrays.toString(solution(arr)));
	}
	
	// t1 "alex pizza pasta","alex pizza pizza","alex noodle","bob pasta","bob noodle sandwich pasta","bob steak noodle"
	// t2 "alex pizza pasta steak","bob noodle sandwich pasta","choi pizza sandwich pizza","alex pizza pasta steak"

	public static String[] solution(String [] arr) {
		// prique 선언
		PriorityQueue<String>pq = new PriorityQueue<>();
		// hashmap 선언
		HashMap<String, HashSet<String>>map = new HashMap<>();
		
		// 토큰으로 잘라서 앞에 것은 이름, 길이 계산할 것
		for(int i = 0; i<arr.length; i++) {
			StringTokenizer st = new StringTokenizer(arr[i]);
			String name = st.nextToken();
			int len = st.countTokens();
			// 맵에 이름이 있는 지 없는 지 검사 , 없으면 맵안에 새로 넣고 , 아니면 안에 나머지 토큰을 넣는다.
			if(map.containsKey(name)) {
				for(int j = 0; j<len; j++) {
					map.get(name).add(st.nextToken());
				}
			}
			else {
				HashSet<String>has = new HashSet<>();
				for(int j = 0; j<len; j++) {
					has.add(st.nextToken());
				}
				map.put(name,has);
			}
		}
		
		// 맥스값 -1 을 기준으로 큰것을 찾는다.
		int max = -1;
		ArrayList<String>list = new ArrayList<>();
		for(String key : map.keySet()) {
			if(max<map.get(key).size()) {
				max = map.get(key).size();
				list = new ArrayList<>();
				list.add(key);
			}
			else if(max==map.get(key).size()) {
				list.add(key);
			}
		}
		
		arr = new String[list.size()];
		
		for(int i = 0; i<list.size(); i++) {
			arr[i] = list.get(i);
		}
		
		return arr;
	}
}
