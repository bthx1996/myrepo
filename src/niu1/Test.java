package niu1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**    
*  
* @author liuweixin  
* @date 2019年7月19日 下午2:09:32  
*/
public class Test {
	public static void main(String[] args) {
		int[] arr = new int[1000];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = 1 + (int)(Math.random()*(100 - 1));
		}
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			}else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		System.out.println(map);
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {

			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}

		});
		for(int i = 0; i <list.size(); i++) {
			System.out.print(list.get(i).getKey()+"\t");
		}
	}

}
