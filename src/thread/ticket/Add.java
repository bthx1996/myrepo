package thread.ticket;

/**    
*  
* @author liuweixin  
* @date 2019年7月31日 下午2:22:32  
*/
public class Add implements Runnable{

	private Ticket ticket;

	
	Add(){
		
	}
	
	Add(Ticket ticket){
		this.ticket = ticket;
	}
	
	@Override
	public void run() {
		while(true) {
			ticket.addTicket();
		}
		
	}
}
