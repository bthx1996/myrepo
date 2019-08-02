package thread;
/**    
*  
* @author liuweixin  
* @date 2019年5月5日 下午2:11:55  
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
		Market market = new Market(10);
		Producer p1 = new Producer(market);
		Producer p2 = new Producer(market);
		Producer p3 = new Producer(market);
		Customer c1 = new Customer(market);
		Customer c2 = new Customer(market);
		Customer c3 = new Customer(market);
		ExecutorService s1 = null;
		s1 = Executors.newCachedThreadPool();
		/*
		while(true) {
			s1.execute(p1);
			s1.execute(p2);
			s1.execute(p3);
			s1.execute(c1);
			s1.execute(c2);
			s1.execute(c3);
			synchronized (market) {			
			System.out.println(market.size());
			for(int i = 0 ; i < market.size(); i++) {
				System.out.print(market.list.get(i).getName()+"\t");
			}
			System.out.println();
			}
		}
		*/
		long start = System.currentTimeMillis();
		System.out.println(start);
		while(true) {
			s1.execute(p1);
			//s1.execute(p2);
			//s1.execute(p3);
			s1.execute(c1);
			//s1.execute(c2);
			//s1.execute(c3);
			if(market.getCount() >= 10000) {
				long end = System.currentTimeMillis();
				System.out.println(end);
				System.out.println("用时："+(end-start));
				System.out.println(market.getCount());
				return;				
			}
		}		
	}
	
	
}
