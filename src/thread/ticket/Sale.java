package thread.ticket;

/**    
*  
* @author liuweixin  
* @date 2019��7��31�� ����2:11:04  
*/
public class Sale implements Runnable{

	private Ticket ticket;

	
	Sale(){
		
	}
	
	Sale(Ticket ticket){
		this.ticket = ticket;
	}
	
	@Override
	public void run() {
		while(true) {
			ticket.saleTicket();
		}			
		
	}
}
