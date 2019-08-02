package stringandbuffer;
/**    
*  
* @author liuweixin  
* @date 2019年5月29日 下午3:28:43  
*/
public class Test {

	public static void main(String[] args) {
		String str = "";
		StringBuffer sb = new StringBuffer();
		long a1 = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			str += i;
		}
		long b1 = System.currentTimeMillis();
		System.out.println("String拼接用时："+(b1-a1));
		long a2 = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			sb.append(i);
		}
		long b2 = System.currentTimeMillis();
		System.out.println("StringBuffer拼接用时："+(b2-a2));
	}
}
