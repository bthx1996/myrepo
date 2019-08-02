package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**    
*  
* @author liuweixin  
* @date 2019年8月1日 下午2:54:15  
*/
public class Test32 {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("\n");
		Matcher m = p.matcher("n");
		System.out.println(m.matches());
		System.out.println("\2");
		String s = "str_".split("_")[0];
		System.out.println("1"+s+"1");
		String str = "footo1";
		String[] strArr = str.split("o");
		for(String ss : strArr) {
			System.out.println(ss);
		}
	}
}
