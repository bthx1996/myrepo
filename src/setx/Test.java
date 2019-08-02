package setx;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**    
*  
* @author liuweixin  
* @date 2019��5��20�� ����9:58:49  
*/
public class Test {

	public static void main(String[] args) {
		Student s = null;
		Set<Student> set = new HashSet<Student>();
		String name = "С��";
		String birth = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		birth = df.format(new Date());
		long a = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			s = new Student();
			s.setName(name+i);
			s.setBirth(birth);
			set.add(s);
		}
		long b = System.currentTimeMillis();
		System.out.println("��ʱ��"+(b-a)+"����");
		
		ExecutorService service = Executors.newCachedThreadPool();
		long a1 = System.currentTimeMillis();
/*		
		for(int i = 0; i < 10; i++) {
			Runnable run = new Runnable() {
				
				@Override
				public void run() {
					for(int j = i*100000; j < (i+1)*100000; j++) {
							for(Student s1 : set) {
								if(s1.getName().equals("С��897876") && s1.getBirth().equals("2019-05-21")) {
									System.out.println("OK");
								}
							};
								
						}
				}
				
			};			
			service.execute(run);
		}
		service.shutdown();
		*/
		//for(int i = 0; i < 1000000; i++) {
			
			//System.out.println(i);
		//}	
		
		//for(int i = 0; i < 1000000; i++) {
			outer:for(Student s1 : set) {
				if(s1.getName().equals("С��897876") && s1.getBirth().equals("2019-05-21")) {
					break outer;
				}
			}
		//System.out.println(i);
		//}
		
		long b1 = System.currentTimeMillis();
		System.out.println("У����ʱ��"+(b1-a1)+"����");
		
	}
	
	public void threadx(Set<Student> set) {
		ExecutorService service = Executors.newCachedThreadPool();
		for(Student s1 : set) {
			Runnable run = new Runnable() {
				public void run() {
					if(s1.getName().equals("С��897876") && s1.getBirth().equals("2019-05-21")) {
						System.out.println("OK");
					}
				}
			};
			service.execute(run);	
			
		}
		service.shutdown();
	}
	
	public void thready(Set<Student> set) {
		
			
		}
}
