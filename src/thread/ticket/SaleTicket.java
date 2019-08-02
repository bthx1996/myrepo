package thread.ticket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**    
*  
* @author liuweixin  
* @date 2019年7月31日 下午2:04:47  
*/
public class SaleTicket {
	
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		Sale sale = new Sale(ticket);
		Add add = new Add(ticket);
		ExecutorService exe = Executors.newFixedThreadPool(8);
		exe.execute(sale);
		exe.execute(sale);
		exe.execute(sale);
		exe.execute(sale);
		exe.execute(add);
		exe.execute(add);
		exe.execute(add);
		exe.execute(add);
		exe.shutdown();
	}
	

}
