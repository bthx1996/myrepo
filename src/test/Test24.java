package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**    
*  
* @author liuweixin  
* @date 2019��7��23�� ����1:52:12  
*/
public class Test24 {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z*]{17}$");
		Matcher m = p.matcher("1234567891234567a*");
		System.out.println(m.matches());
	}
}
