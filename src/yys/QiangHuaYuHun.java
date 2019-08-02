package yys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**    
*  
* @author liuweixin  
* @date 2019年3月7日 下午4:54:07  
*/
public class QiangHuaYuHun {
	private List<String> tarr = new ArrayList<String>();
	private YuHun yh = null;
	
	public QiangHuaYuHun() {
		
	}
	
	public QiangHuaYuHun(YuHun yh1) {
		this.yh = yh1;
		Set key = yh.getfProperty().keySet();
		tarr.addAll(key);
	}
	public void qiangHua() {
		yh.setLevel(yh.getLevel()+1);
		qiangHuaZhu();
		if(yh.getLevel() != 0 && yh.getLevel() % 3 == 0) {
			qiangHuaFu();
		}
		
	}
	
	private void qiangHuaZhu() {
		String name = yh.getzProperty().keySet().toArray(new String[0])[0];
		double value = yh.getzProperty().get(name);
		String place = yh.getPlace();
		switch(place) {
		case "1":value += 27;
				break;
		case "2":if(name.equals("速度")) {
					value += 3;
				}else {
					value += 0.03;
				}		
				break;
		case "3":value += 6;
				break;
		case "4":value += 0.03;
				break;
		case "5":value += 114;
				break;
		case "6":if(name.equals("暴击伤害")) {
					value += 0.05;
				}else {
					value += 0.03;
				}
				break;
		}
		yh.getzProperty().put(name, value);
		
	}
	
	private void qiangHuaFu() {
		String[] nameArr = (String[]) yh.getfProperty().keySet().toArray(new String[0]);
		if(nameArr.length == 4) {
			qiangHuaFuExist();						
		}else {
			Map map_t = Utils.randomProperty("fu");
			String name = (String) map_t.keySet().toArray(new String[0])[0];
			if(yh.getfProperty().containsKey(name)) {
				double[] range = Utils.fu.get(name);
				double value = (double) yh.getfProperty().get(name);
				value += Utils.randomDouble(range[0], range[1]);
				yh.getfProperty().put(name, value);
				tarr.add(name);
			}else {
				double[] range = (double[]) map_t.get(name);
				double value = Utils.randomDouble(range[0], range[1]);				
				yh.getfProperty().put(name,value);
				tarr.add(name);
			}
		}
	}
	
	private void qiangHuaFuExist() {
		int ran = Utils.randomInt(0, tarr.size());
		String name = tarr.get(ran);
		double[] range = Utils.fu.get(name);
		double value = (double) yh.getfProperty().get(name);
		value += Utils.randomDouble(range[0], range[1]);
		yh.getfProperty().put(name, value);
		tarr.add(name);
	}
	
}
