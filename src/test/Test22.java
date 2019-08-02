package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.collections.ListUtils;

/**    
*  
* @author liuweixin  
* @date 2019年7月16日 下午2:20:08  
*/
public class Test22 {

	public static void main(String[] args) {
		concatInt();
		char a = '中';
	}

	public static void concatInt() {
		Scanner sca = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		System.out.println("个数：");
		int count = sca.nextInt();
		int flag = 0;
		while(flag < count) {
			System.out.println("输入正整数：");
			String ss = sca.next();
			list.add(ss);
			flag++;
		}
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				String strMin = str1.length() < str2.length()? str1:str2;
				String strMax = str1.length() < str2.length()?str2:str1;
				for(int i = 0; i < strMin.length(); i++) {
					if(strMin.charAt(i) > strMax.charAt(i)) {
						return -1;
					}
				}
				return 1;
			}
		});
		
		String max = "";
		for(String s : list) {
			max+=s;
		}
		System.out.println(max);
	}
	
	public static boolean compare(String str1, String str2) {
		String strMin = str1.length() < str2.length()? str1:str2;
		String strMax = str1.length() < str2.length()?str2:str1;
		for(int i = 0; i < strMin.length(); i++) {
			if(strMin.charAt(i) > strMax.charAt(i)) {
				return true;
			}
		}
		return false;
	}
}
