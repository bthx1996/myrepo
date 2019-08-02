package thread;
/**    
*  
* @author liuweixin  
* @date 2019年5月5日 下午2:04:29  
*/
public class Customer implements Runnable{

	private Market market;
	
	public Customer() {
		
	}

	public Customer(Market market) {
		this.market = market;
	}
	@Override
	public void run() {
		synchronized (market) {
			Book book = null;			
			try {
				book = market.sale();
				//System.out.println("消费者"+Thread.currentThread().getName()+"买了"+book.getName());
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
