package test;
/**    
*  
* @author liuweixin  
* @date 2019��6��3�� ����7:46:57  
*/
class Other{
	public Other() {
		System.out.println("other");
	}
}

public class Test14 extends Other{
	public static void main(String[] args) {
		new Test14();
		new Other();
	}
}