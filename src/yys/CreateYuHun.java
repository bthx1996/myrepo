package yys;

import java.util.Map;

/**    
*  
* @author liuweixin  
* @date 2019年3月6日 下午3:07:14  
*/
public class CreateYuHun {
	
	public YuHun getYuHun() {
		YuHun yh = new YuHun();
		Map map = null;
		map = Utils.randomProperty("type");
		yh.setType(map);
		int place = Utils.randomInt(1, 7);
		yh.setPlace(String.valueOf(place));
		map = Utils.randomProperty(String.valueOf(place));
		yh.setzProperty(map);
		map = Utils.randomFu();
		yh.setfProperty(map);
		return yh;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			System.out.println(new CreateYuHun().getYuHun());
		}
		
	}
}
