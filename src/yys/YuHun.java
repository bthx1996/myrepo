package yys;

import java.util.HashMap;
import java.util.Map;

/**    
*  
* @author liuweixin  
* @date 2019年3月6日 下午3:07:50  
*/
public class YuHun {
	private int level = 0;
	private String place;//位置
	private Map<String,String> type;//类型
	private Map<String,Double> zProperty = new HashMap<String,Double>();
	private Map<String,Double> fProperty = new HashMap<String,Double>();
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	public Map<String, String> getType() {
		return type;
	}
	public void setType(Map<String, String> type) {
		this.type = type;
	}
	public void setfProperty(Map<String, Double> fProperty) {
		this.fProperty = fProperty;
	}
	public Map<String, Double> getzProperty() {
		return zProperty;
	}
	public void setzProperty(Map<String, Double> zProperty) {
		this.zProperty = zProperty;
	}
	public Map getfProperty() {
		return fProperty;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		String[] typ = type.keySet().toArray(new String[0]);
		sb.append("两件套属性："+type.get(typ[0]) +"\t"+ place + "号位"+typ[0]);
		String[] zhu = zProperty.keySet().toArray(new String[0]);
		sb.append("\t主属性："+zhu[0]+" "+Utils.transform(zhu[0],zProperty.get(zhu[0])));
		String[] fu = fProperty.keySet().toArray(new String[0]);
		sb.append("\t副属性：");
		for(int i = 0; i < fu.length; i++) {
			String value = Utils.transform(fu[i],fProperty.get(fu[i]));
			sb.append(fu[i]+" "+value+"|\t");
		}
		return sb.toString();
	}
	
	
}
