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
* @date 2019��3��6�� ����3:27:35  
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
		type.put("�����", "�����ӳ�15%");
		type.put("��", "�����ӳ�15%");
		type.put("��Ħ��", "�����ӳ�15%");
		type.put("����", "�����ӳ�15%");
		type.put("����", "�����ӳ�15%");
		type.put("����", "�����ӳ�15%");
		type.put("����", "�����ӳ�15%");
		type.put("�ز�", "�����ӳ�15%");
		type.put("��Ů", "����15%");
		type.put("����", "����15%");
		type.put("����", "����15%");
		type.put("��ζ", "����15%");
		type.put("����", "�����ӳ�30%");
		type.put("�в�è", "�����ӳ�30%");
		type.put("ѩ�Ļ�", "�����ӳ�30%");
		type.put("��Ů", "�����ӳ�30%");
		type.put("����", "Ч������15%");
		type.put("����", "Ч������15%");
		type.put("����֮ϻ", "Ч���ֿ�15%");
		place1.put("����", 81.00);
		place3.put("����", 14.00);
		place5.put("����", 342.00);
		place2.put("�ٶ�", 12.00);
		place2.put("�����ӳ�", 0.10);
		place2.put("�����ӳ�", 0.10);
		place2.put("�����ӳ�", 0.10);
		place4.put("Ч������", 0.10);
		place4.put("Ч���ֿ�", 0.10);
		place4.put("�����ӳ�", 0.10);
		place4.put("�����ӳ�", 0.10);
		place4.put("�����ӳ�", 0.10);
		place6.put("�����˺�", 0.14);
		place6.put("����", 0.10);
		place6.put("�����ӳ�", 0.10);
		place6.put("�����ӳ�", 0.10);
		place6.put("�����ӳ�", 0.10);
		fu.put("����", new double[] {4.1,4.8});
		fu.put("����", new double[] {0.025,0.031});
		fu.put("�����ӳ�", new double[] {0.025,0.031});
		fu.put("�ٶ�", new double[] {2.5,3.01});
		fu.put("�����ӳ�", new double[] {0.025,0.031});
		fu.put("�����ӳ�", new double[] {0.025,0.031});
		fu.put("����", new double[] {19.1,23.2});
		fu.put("����", new double[] {98.9,102.1});
		fu.put("�����˺�", new double[] {0.033,0.041});
		fu.put("Ч������", new double[] {0.033,0.041});
		fu.put("Ч���ֿ�", new double[] {0.033,0.041});
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
		if(key.equals("����") || key.length() == 4) {
			DecimalFormat df = new DecimalFormat("0%");
			return df.format(value);
		}else {
			return new BigDecimal(value).setScale(0,BigDecimal.ROUND_UP).toString();
		}
				
	}
	
}
