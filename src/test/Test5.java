package test;
/**    
*  
* @author liuweixin  
* @date 2019��4��10�� ����6:28:33  
*/
public class Test5 {

	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.println(j);
				break;
			}
			System.out.println(i);
		}
	}
}
