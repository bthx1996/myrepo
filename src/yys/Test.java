package yys;
/**    
*  
* @author liuweixin  
* @date 2019��3��8�� ����2:50:32  
*/
public class Test {
	public static void main(String[] args) {
		int j = 0;
		//while(j<10){
			YuHun yh = new CreateYuHun().getYuHun();
			System.out.println("�������꣺\t"+yh);
			QiangHuaYuHun qhyh = new QiangHuaYuHun(yh);
			for(int i = 0; i < 15; i++) {
				qhyh.qiangHua();
			}
			System.out.println("ǿ����\t"+yh);
		//	j++;
		//}
		
	}
}
