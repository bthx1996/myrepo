package test;

import java.util.HashMap;
import java.util.Map;

/**    
*  
* @author liuweixin  
* @date 2019年7月23日 下午5:45:43  
*/
public class Test25 {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		int i = 1;
		for(char a = 'A'; a < 'Z'; a++) {
			map.put(String.valueOf(a), String.valueOf(i));
			i++;
		}
		map.put(" ", "*");
		map.put(".", "\r\n");
		String str = "HOW ARE YOU.YES.";
		String strNew = "";
		for(int j = 0; j < str.length(); j++) {
			String s = String.valueOf(str.charAt(j));
			strNew += map.get(s);
		}
		System.out.println(strNew);
	}
}
