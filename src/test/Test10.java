package test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**    
*  
* @author liuweixin  
* @date 2019年5月15日 下午4:31:30  
*/
public class Test10 {

	public static void main(String[] args) {
		//Scanner sca = new Scanner(System.in);
		//String str = sca.next();
		String str = "32+5*2-40/3";
		/*
		Pattern p = Pattern.compile("(([0-9]+)(\\+\\-\\*\\/)?)+");
		Matcher m = p.matcher(str);
		System.out.println(m.find());
		System.out.println(m.groupCount());
		System.out.println(m.group(1));
		System.out.println(m.group(2));
		System.out.println(m.group(3));
		*/
		String[] sub = str.split("\\+|\\-|\\*|\\/");
		for(String s : sub) {
			System.out.println(s);
		}
		
	}

}
