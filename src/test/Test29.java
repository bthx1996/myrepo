package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**    
*  
* @author liuweixin  
* @date 2019年7月29日 上午9:16:17  
*/
public class Test29 {

	public static void main(String[] args) {
		
//		List<Integer> list1 = new ArrayList<Integer>();
//		List<Integer> list2 = new ArrayList<Integer>();
//		List<Integer> list3 = new ArrayList<Integer>();
//		List<Integer> list4 = new ArrayList<Integer>();
//		for(int i = 1; i <= 100000; i++) {
//			list1.add(i);
//			list2.add(i);
//			list3.add(i);
//			list4.add(i);
//			//System.out.println(i);
//		}
		
		/*
		long a = System.currentTimeMillis();
		ExecutorService exe = Executors.newFixedThreadPool(2);
		CountDownLatch cdl = new CountDownLatch(2);
		exe.execute(new Test29().new MyRun(0,cdl));
		exe.execute(new Test29().new MyRun(100000,cdl));
//		exe.execute(new Test29().new MyRun(200000,cdl));
//		exe.execute(new Test29().new MyRun(300000,cdl));
//		exe.execute(new Test29().new MyRun(400000,cdl));
//		exe.execute(new Test29().new MyRun(500000,cdl));
//		exe.execute(new Test29().new MyRun(600000,cdl));
//		exe.execute(new Test29().new MyRun(700000,cdl));
//		exe.execute(new Test29().new MyRun(800000,cdl));
//		exe.execute(new Test29().new MyRun(900000,cdl));
		exe.shutdown();
		try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long b = System.currentTimeMillis();
		System.out.println("多线程："+(b-a));
		
		
		
		long aa = System.currentTimeMillis();
		for(int i = 1; i <= 20; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long bb = System.currentTimeMillis();
		System.out.println("单线程："+(bb-aa));
		*/
		/*
		String str = "update xxxxxxx set xxx = xxx where id in (";
		for(int i = 1; i <= 10000; i++) {
			str+="2147483647"+i+",";
			System.out.println(i);
		}
		str += ")";
		System.out.println(str);
		System.out.println(str.length());
		System.out.println(str.getBytes().length/1024);
		 for (int i = 0; i <1400; i++) { 
	            System.out.print(i); 
	        }
	      */
		Demo demo = new Test29().new Demo();
		ExecutorService exe = Executors.newFixedThreadPool(2);
		CountDownLatch cdl = new CountDownLatch(2);
		exe.execute(new Test29().new MyRun2(demo,cdl));
		exe.execute(new Test29().new MyRun2(demo,cdl));
		try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exe.shutdown();
		System.out.println(demo.getCount());
	}
	
	private class MyRun implements Runnable{

		private int begin;
		
		private CountDownLatch cdl = null;
		
		MyRun(){
			
		}
		
		MyRun(int begin,CountDownLatch cdl){
			this.begin = begin;
			this.cdl = cdl;
		}
		@Override
		public void run() {
			System.out.println(Thread.currentThread());
			for(int i = begin; i < begin+10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
			}
			cdl.countDown();
		}
		
	}
	
	private class MyRun2 implements Runnable{

		private Demo demo;
		
		private CountDownLatch cdl = null;
		
		MyRun2(){
			
		}
		
		MyRun2(Demo demo,CountDownLatch cdl){
			this.demo = demo;
			this.cdl = cdl;
		}
		@Override
		public void run() {
			demo.setCount(demo.getCount()+1);
			System.out.println(Thread.currentThread()+":"+demo.getCount());
			cdl.countDown();
		}
		
	}
	
	 class Demo{
		private int count = 0;

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
		
		
	}
}
