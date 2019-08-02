/**
 * 
 */
package thread;

import java.util.Random;

/**    
*  
* @author liuweixin  
* @date 2019年5月5日 下午1:54:29  
*/
/**
 * @author liuweixin
 * @date 2019年5月5日 下午1:54:29
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
				book.setName("书"+i);
				book.setPrice(i);
				market.addBook(book);
				//System.out.println("生产者"+Thread.currentThread().getName()+"生产了"+book.getName());
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
