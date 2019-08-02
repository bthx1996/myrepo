/**
 * 
 */
package thread;

import java.util.Random;

/**    
*  
* @author liuweixin  
* @date 2019��5��5�� ����1:54:29  
*/
/**
 * @author liuweixin
 * @date 2019��5��5�� ����1:54:29
 * 
 */
public class Producer implements Runnable{

	private Market market;
	
	
	public Producer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producer(Market market) {
		this.market = market;
	}
	
	
	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}

	@Override
	public void run() {
		synchronized (market) {
			Book book = new Book();
			try {
				int i = new Random().nextInt(100);
				book.setName("��"+i);
				book.setPrice(i);
				market.addBook(book);
				//System.out.println("������"+Thread.currentThread().getName()+"������"+book.getName());
			} catch (BookException e) {
				try {
				market.notifyAll();
				market.wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}

}
