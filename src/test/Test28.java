package test;
/**    
*  
* @author liuweixin  
* @date 2019��7��26�� ����10:28:41  
*/
public class Test28 {

	public static void main(String[] args) {
		Integer num = new Integer(128);
		num++;
		Integer num2 = new Integer(128);
		num2++;
		//int num1 = 129;
		System.out.println(num2.equals(num));
	}
}
