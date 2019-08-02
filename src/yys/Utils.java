package yys;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**    
*  
* @author liuweixin  
* @date 2019年3月6日 下午3:27:35  
*/
public class Utils {
	public final static Map<String,String> type = new HashMap<String,String>();
	public final static Map<String,Double> place1 = new HashMap<String,Double>();
	public final static Map<String,Double> place2 = new HashMap<String,Double>();
	public final static Map<String,Double> place3 = new HashMap<String,Double>();
	public final static Map<String,Double> place4 = new HashMap<String,Double>();
	public final static Map<String,Double> place5 = new HashMap<String,Double>();
	public final static Map<String,Double> place6 = new HashMap<String,Double>();
	public final static Map<String,double[]> fu = new HashMap<String,double[]>();
	static {
		type.put("轮入道", "攻击加成15%");
		type.put("狰", "攻击加成15%");
		type.put("阴摩罗", "攻击加成15%");
		type.put("蝠翼", "攻击加成15%");
		type.put("树妖", "生命加成15%");
		type.put("钟灵", "生命加成15%");
		type.put("镜姬", "生命加成15%");
		type.put("地藏", "生命加成15%");
		type.put("针女", "暴击15%");
		type.put("破势", "暴击15%");
		type.put("网切", "暴击15%");
		type.put("三味", "暴击15%");
		type.put("魅妖", "防御加成30%");
		type.put("招财猫", "防御加成30%");
		type.put("雪幽魂", "防御加成30%");
		type.put("日女", "防御加成30%");
		type.put("火灵", "效果命中15%");
		type.put("蚌精", "效果命中15%");
		type.put("魍魉之匣", "效果抵抗15%");
		place1.put("攻击", 81.00);
		place3.put("防御", 14.00);
		place5.put("生命", 342.00);
		place2.put("速度", 12.00);
		place2.put("攻击加成", 0.10);
		place2.put("生命加成", 0.10);
		place2.put("防御加成", 0.10);
		place4.put("效果命中", 0.10);
		place4.put("效果抵抗", 0.10);
		place4.put("攻击加成", 0.10);
		place4.put("生命加成", 0.10);
		place4.put("防御加成", 0.10);
		place6.put("暴击伤害", 0.14);
		place6.put("暴击", 0.10);
		place6.put("攻击加成", 0.10);
		place6.put("生命加成", 0.10);
		place6.put("防御加成", 0.10);
		fu.put("防御", new double[] {4.1,4.8});
		fu.put("暴击", new double[] {0.025,0.031});
		fu.put("攻击加成", new double[] {0.025,0.031});
		fu.put("速度", new double[] {2.5,3.01});
		fu.put("防御加成", new double[] {0.025,0.031});
		fu.put("生命加成", new double[] {0.025,0.031});
		fu.put("攻击", new double[] {19.1,23.2});
		fu.put("生命", new double[] {98.9,102.1});
		fu.put("暴击伤害", new double[] {0.033,0.041});
		fu.put("效果命中", new double[] {0.033,0.041});
		fu.put("效果抵抗", new double[] {0.033,0.041});
	}
	public static int randomInt(int min, int max) {
		int ran = new Random().nextInt(max - min) + min;
		return ran;		
	}
	
	public static double randomDouble(double min, double max) {
		double ran = Math.random()*(max-min)+min;
		return ran;		
	}
	
	public static Map randomMap(Map map) {
		String[] keys = (String[]) map.keySet().toArray(new String[0]);
		String key = keys[randomInt(0,map.size())];
		Map map2 = new HashMap();
		map2.put(key, map.get(key));
		return map2;		
	}
	
	public static Map randomProperty(String mapType) {
		Map map = null;
		switch(mapType) {
		 case "type" : map = randomMap(type);
					break;
		 case "1" : map = randomMap(place1);
		 			break;
		 case "2" : map = randomMap(place2);
					break;
		 case "3" : map = randomMap(place3);
					break;
		 case "4" : map = randomMap(place4);
					break;
		 case "5" : map = randomMap(place5);
					break;
		 case "6" : map = randomMap(place6);
					break;
		 case "fu" : map = randomMap(fu);
					break;
		 default : break;
		}
		return map;
	}

	public static Map<String,Double> randomFu() {
		Map<String,Double> map = new HashMap<String,Double>();
		int count = randomInt(2,5);
		for(int i = 0; i < count; i++) {
			Map map_t = randomProperty("fu");
			String[] keys = (String[]) map_t.keySet().toArray(new String[0]);
			String p = keys[0];
			if(map.containsKey(p)) {
				i--;
				continue;
			}
			double[] range = (double[]) map_t.get(p);
			double value = randomDouble(range[0], range[1]);
			map.put(p, value);
		}
		return map;
	}
	
	public static String transform(String key, double value) {
		if(key.equals("暴击") || key.length() == 4) {
			DecimalFormat df = new DecimalFormat("0%");
			return df.format(value);
		}else {
			return new BigDecimal(value).setScale(0,BigDecimal.ROUND_UP).toString();
		}
				
	}
	
}
