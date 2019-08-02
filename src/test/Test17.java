package test;

import java.util.Scanner;

/**    
*  
* @author liuweixin  
* @date 2019年6月17日 下午7:45:31  
*/
public class Test17 {

	public static void main(String[] args) {
		
		Scanner sca = new Scanner(System.in);
		String str = sca.nextLine();
		StringBuffer sb1 = new StringBuffer(str);
		Long num1 = null;
		Long num2 = null;
		Long sum = null;
		int i = 0;
		while(!isHui(sb1.toString())) {
			i++;
			num1 = Long.valueOf(sb1.toString());
			num2 = Long.valueOf(sb1.reverse().toString());
			sum = num1 + num2;
			System.out.print("第"+i+"次："+num1+"\t"+num2+"\t");
			sb1.setLength(0);
			sb1.append(sum.toString());
			System.out.println(sb1);
		}
		System.out.println("回数："+sb1);
	}
	
	public static boolean isHui(String str) {
		StringBuffer sb = new StringBuffer(str);
		if(sb.reverse().toString().equals(str)) {
			return true;
		}
		return false;
	}
}
