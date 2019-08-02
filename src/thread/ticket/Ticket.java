package thread.ticket;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**    
*  
* @author liuweixin  
* @date 2019��7��31�� ����2:19:08  
*/
public class Ticket {

	private int num = 100;
	private Lock lock = new ReentrantLock();
	private Condition conditionSale = lock.newCondition();
	private Condition conditionAdd = lock.newCondition();
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void addTicket() {
		lock.lock();
		if(num < 100) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			num++;
			System.out.println(Thread.currentThread()+"����Ʊ��"+num);
		}else {
			try {
				System.out.println("Ʊ������");
				conditionAdd.await();
				conditionSale.signalAll();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lock.unlock();
	}
	
	public void saleTicket() {
		lock.lock();
		if(num > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread()+"��Ʊ��"+num);
			num--;			
		}else {
			try {
				System.out.println("Ʊ����");
				conditionSale.await();
				conditionAdd.signalAll();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		lock.unlock();
	}
}
