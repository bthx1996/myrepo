package thread;

import java.util.ArrayList;
import java.util.List;

/**    
*  
* @author liuweixin  
* @date 2019年5月5日 下午1:43:32  
*/
public class Market {

	List<Book> list = new ArrayList<Book>();
	private int length = 20;
	private int count = 0;
	
	public Market() {
		// TODO Auto-generated constructor stub
	}
	
	public Market(int length){
		this.length = length;
	}
	
	//进货
	public void addBook(Book book) throws BookException {
		if(list.size() >= length) {
			throw new BookException("库存已满！");
		}
		list.add(book);
		count++;
	}
	
	//销售
	public Book sale() throws BookException {
		if(list.size() == 0) {
			throw new BookException("库存不足！请等待进货...");
		}
		return list.remove(0);
	}
	
	public int size() {
		return list.size();
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
