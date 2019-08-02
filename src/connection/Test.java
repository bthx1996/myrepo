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
* @date 2019��4��11�� ����11:02:53  
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
			System.out.println("set���ǰ��"+start);
			for(int i = 0; i < 1000000; i++) {
				set.add(String.valueOf(i));
			}
			long end = System.currentTimeMillis();
			System.out.println("set��ź�"+end);
			System.out.println("�����ʱ��"+(end-start)/60+"��");
			
			long start1 = System.currentTimeMillis();
			System.out.println("set����ǰ��"+start1);
			for(String s : set) {
				
			}
			long end1 = System.currentTimeMillis();
			System.out.println("set������"+end1);
			System.out.println("������ʱ��"+(end1-start1)+"����");
			
			long start2 = System.currentTimeMillis();
			System.out.println("set�������ǰ��"+start2);
			System.out.println("��֧�֡�����");
			long end2 = System.currentTimeMillis();
			System.out.println("set���������"+end2);
			System.out.println("���������ʱ��"+(end2-start2)+"����");
		}else if(c instanceof Map){
			Map<String,String> map = ((Map<String, String>) c);
			long start = System.currentTimeMillis();
			System.out.println("map���ǰ��"+start);
			for(int i = 0; i < 1000000; i++) {
				map.put(String.valueOf(i+1),String.valueOf(i));
			}
			long end = System.currentTimeMillis();
			System.out.println("map��ź�"+end);
			System.out.println("�����ʱ��"+(end-start)/60+"��");
			
			long start1 = System.currentTimeMillis();
			System.out.println("map����ǰ��"+start1);
			for(String key : map.keySet()) {
				map.get(key);
			}
			long end1 = System.currentTimeMillis();
			System.out.println("map������"+end1);
			System.out.println("������ʱ��"+(end1-start1)+"����");
			long start2 = System.currentTimeMillis();
			System.out.println("map�������ǰ��"+start2);
			map.get("99998");
			long end2 = System.currentTimeMillis();
			System.out.println("map���������"+end2);
			System.out.println("���������ʱ��"+(end2-start2)+"����");
		}else if(c instanceof List){
			List<String> list = ((List<String>) c);
			long start = System.currentTimeMillis();
			System.out.println("list���ǰ��"+start);
			for(int i = 0; i < 1000000; i++) {
				list.add(String.valueOf(i));
			}
			long end = System.currentTimeMillis();
			System.out.println("list��ź�"+end);
			System.out.println("�����ʱ��"+(end-start)/60+"��");
			
			long start1 = System.currentTimeMillis();
			System.out.println("list����ǰ��"+start1);
			for(String s : list) {
			}
			long end1 = System.currentTimeMillis();
			System.out.println("list������"+end1);
			System.out.println("������ʱ��"+(end1-start1)+"����");
			
			long start2 = System.currentTimeMillis();
			System.out.println("list�������ǰ��"+start2);
			list.get(99998);
			long end2 = System.currentTimeMillis();
			System.out.println("list���������"+end2);
			System.out.println("���������ʱ��"+(end2-start2)+"����");
		}else {
			System.out.println("���ʹ���");
		}
		
	}
}
