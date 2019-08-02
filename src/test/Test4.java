package test;
/**    
*  
* @author liuweixin  
* @date 2019年3月25日 上午10:05:54  
*/
public class Test4 {
	public static void main(String[] args) {
		int[] a = new int[] {1,2,3,4,5,6,7,8,9,10};
		int[] b = new int[10];
		System.arraycopy(a, 0, b, 0, 10);
		for(int c : b) {
			System.out.println(c);
		}
	}
}
