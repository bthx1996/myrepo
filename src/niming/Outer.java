package niming;
/**    
*  
* @author liuweixin  
* @date 2019年2月14日 上午9:38:31  
*/
public class Outer {
	public Outer() {}
	class Inner{
		private Inner() {}
		
		void play() {
			System.out.println("hhh");
		}
	}
	void method() {
		new Inner();
	}
	public static void main(String[] args) {
		new Outer().new Inner().play();
	}
}
