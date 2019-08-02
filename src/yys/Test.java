package yys;
/**    
*  
* @author liuweixin  
* @date 2019年3月8日 下午2:50:32  
*/
public class Test {
	public static void main(String[] args) {
		int j = 0;
		//while(j<10){
			YuHun yh = new CreateYuHun().getYuHun();
			System.out.println("创建御魂：\t"+yh);
			QiangHuaYuHun qhyh = new QiangHuaYuHun(yh);
			for(int i = 0; i < 15; i++) {
				qhyh.qiangHua();
			}
			System.out.println("强化后：\t"+yh);
		//	j++;
		//}
		
	}
}
