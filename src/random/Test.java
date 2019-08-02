package random;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**    
*  
* @author liuweixin  
* @date 2019年7月19日 下午5:11:21  
*/
public class Test {

	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int total = 1000;
		int seed = 66;
		int num = 0;
		StringBuffer sb = new StringBuffer();
		Random ran = new Random(seed);
		for(int i = 0; i < total; i++) {
			num = ran.nextInt(100);//种子固定，则每次运行产生的随机数固定44 87 3 3 36 41 74 79 22 26 17 92 52 28 23 72 60 84 71 78 45 52 62 5......
			//num = 1 + (int)(Math.random()*(100 - 1));
			sb.append(num+" ");
			if(!map.containsKey(num)) {
				map.put(num, 1);
			}else {
				map.put(num, map.get(num)+1);
			}
		}
		System.out.println(sb);
		System.out.println(map);
		System.out.println("种子"+seed+"出现次数："+map.get(seed));
		System.out.println("种子"+seed+"出现概率："+new DecimalFormat("0.000%").format((float)map.get(seed)/total));
	}
}
