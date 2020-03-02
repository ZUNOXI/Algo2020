package selfmadeCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class 오토에버복기2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, HashSet<String>>map = new HashMap<>();
		
		String [] arr = {"alex pizza pasta steak","bob noodle sandwich pasta","choi pizza sandwich pizza","alex pizza pasta steak"};
		
		Arrays.sort(arr);
		
		int len = arr.length;
		 
		for(int i = 0; i<len; i++) {
			String s = arr[i];
			
			String [] sarr = s.split(" ");
			
			String name = sarr[0];
			
			if(map.containsKey(name)) {
				for(int j = 1; j<sarr.length; j++) {
						map.get(name).add(sarr[j]);
					}
				}
			
			else {
				HashSet<String>temp = new HashSet<>();
				for(int j = 1; j<sarr.length; j++) {
					temp.add(sarr[j]);
				}
				map.put(name, temp);
			}
			
		}
		
		int max = -1;
		
		LinkedList<String>list = new LinkedList<>(); 
		
		for(String key : map.keySet()) {
			if(map.get(key).size()>max) {
				list = new LinkedList<>(); 
				list.add(key);
			}
			else if(map.get(key).size()==max) {
				list.add(key);
			}
		}
		
		System.out.println(list.toString());
	}
	
	// t1 "alex pizza pasta","alex pizza pizza","alex noodle","bob pasta","bob noodle sandwich pasta","bob steak noodle"
	// t2 "alex pizza pasta steak","bob noodle sandwich pasta","choi pizza sandwich pizza","alex pizza pasta steak"


}
