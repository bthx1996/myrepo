package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**    
*  
* @author liuweixin  
* @date 2019��5��13�� ����10:10:26  
*/
public class Test9 {
	public static void main(String[] args) {
		
		Pattern p = Pattern.compile("^[0-9]{10}\\([A-Za-z]\\)$");
		Matcher m = p.matcher("1111111111(a)");
		System.out.println(m.matches());
		
		/*
		Pattern p=Pattern.compile("([a-z]+)([0-9]+)"); 
		Matcher m=p.matcher("aaa2223bb"); 
		//System.out.println(m.matches());;
		System.out.println(m.find());;   //ƥ��aaa2223 
		System.out.println(m.groupCount());;   //����2,��Ϊ��2�� 
		System.out.println(m.start(1));;   //����0 ���ص�һ��ƥ�䵽�����ַ������ַ����е������� 
		System.out.println(m.start(2));;   //����3 
		System.out.println(m.end(1));;   //����3 ���ص�һ��ƥ�䵽�����ַ��������һ���ַ����ַ����е�����λ��. 
		System.out.println(m.end(2));;   //����7 
		System.out.println(m.group(1));;   //����aaa,���ص�һ��ƥ�䵽�����ַ��� 
		System.out.println(m.group(2));;   //����2223,���صڶ���ƥ�䵽�����ַ���
		System.out.println(m.group());
		*/
	}
}
