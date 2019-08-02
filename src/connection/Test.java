package connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**    
*  
* @author liuweixin  
* @date 2019年4月11日 上午11:02:53  
*/
public class Test {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		Map<String, String> map = new HashMap<String,String>();
		List<String> list = new ArrayList<String>();
		testSpeed(set);
		System.out.println("************************");
		testSpeed(map);
		System.out.println("************************");
		testSpeed(list);
	}
	
	@SuppressWarnings("unchecked")
	public static void testSpeed(Object c) {
		if(c instanceof Set) {
			Set<String> set = (Set<String>) c;
			long start = System.currentTimeMillis();
			System.out.println("set存放前："+start);
			for(int i = 0; i < 1000000; i++) {
				set.add(String.valueOf(i));
			}
			long end = System.currentTimeMillis();
			System.out.println("set存放后："+end);
			System.out.println("存放用时："+(end-start)/60+"秒");
			
			long start1 = System.currentTimeMillis();
			System.out.println("set遍历前："+start1);
			for(String s : set) {
				
			}
			long end1 = System.currentTimeMillis();
			System.out.println("set遍历后："+end1);
			System.out.println("遍历用时："+(end1-start1)+"毫秒");
			
			long start2 = System.currentTimeMillis();
			System.out.println("set随机遍历前："+start2);
			System.out.println("不支持。。。");
			long end2 = System.currentTimeMillis();
			System.out.println("set随机遍历后："+end2);
			System.out.println("随机遍历用时："+(end2-start2)+"毫秒");
		}else if(c instanceof Map){
			Map<String,String> map = ((Map<String, String>) c);
			long start = System.currentTimeMillis();
			System.out.println("map存放前："+start);
			for(int i = 0; i < 1000000; i++) {
				map.put(String.valueOf(i+1),String.valueOf(i));
			}
			long end = System.currentTimeMillis();
			System.out.println("map存放后："+end);
			System.out.println("存放用时："+(end-start)/60+"秒");
			
			long start1 = System.currentTimeMillis();
			System.out.println("map遍历前："+start1);
			for(String key : map.keySet()) {
				map.get(key);
			}
			long end1 = System.currentTimeMillis();
			System.out.println("map遍历后："+end1);
			System.out.println("遍历用时："+(end1-start1)+"毫秒");
			long start2 = System.currentTimeMillis();
			System.out.println("map随机遍历前："+start2);
			map.get("99998");
			long end2 = System.currentTimeMillis();
			System.out.println("map随机遍历后："+end2);
			System.out.println("随机遍历用时："+(end2-start2)+"毫秒");
		}else if(c instanceof List){
			List<String> list = ((List<String>) c);
			long start = System.currentTimeMillis();
			System.out.println("list存放前："+start);
			for(int i = 0; i < 1000000; i++) {
				list.add(String.valueOf(i));
			}
			long end = System.currentTimeMillis();
			System.out.println("list存放后："+end);
			System.out.println("存放用时："+(end-start)/60+"秒");
			
			long start1 = System.currentTimeMillis();
			System.out.println("list遍历前："+start1);
			for(String s : list) {
			}
			long end1 = System.currentTimeMillis();
			System.out.println("list遍历后："+end1);
			System.out.println("遍历用时："+(end1-start1)+"毫秒");
			
			long start2 = System.currentTimeMillis();
			System.out.println("list随机遍历前："+start2);
			list.get(99998);
			long end2 = System.currentTimeMillis();
			System.out.println("list随机遍历后："+end2);
			System.out.println("随机遍历用时："+(end2-start2)+"毫秒");
		}else {
			System.out.println("类型错误！");
		}
		
	}
}
