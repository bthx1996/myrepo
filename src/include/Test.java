package include;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**    
*  
* @author liuweixin  
* @date 2019年6月27日 上午9:18:26  
*/
public class Test {
	
	public static void main(String[] args) {
		String[] strArr = new String[10];
		for(int i = 0; i < 10; i++) {
			strArr[i] = String.valueOf(i);
		}
		
		long a1 = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			useLoop(strArr, "9999");
		}		
		long b1 = System.currentTimeMillis();
		System.out.println("foreach用时："+(b1-a1));
		long a2 = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			useLoop2(strArr, "9999");
		}
		long b2 = System.currentTimeMillis();
		System.out.println("contains用时："+(b2-a2));
		long a3 = System.currentTimeMillis();
		String target = "999";
		for(int i = 0; i < 1000000; i++) {
			if(!"0".equals(target) && !"0".equals(target) && !"0".equals(target) && !"0".equals(target) && !"0".equals(target)) {
				
			}
		}
		long b3 = System.currentTimeMillis();
		System.out.println("3用时："+(b3-a3));
	}

	public static boolean useLoop(String[] arr, String targetValue) {
		for (String s : arr) {
			if (s!=targetValue)
				return true;
		}
		return false;
	}
	
	public static boolean useLoop2(String[] arr, String targetValue) {
		List<String> list = Arrays.asList(arr);
		return list.contains(targetValue);
	}
	
}
