package fuzhi;
/**    
*  
* @author liuweixin  
* @date 2019年5月21日 下午5:37:48  
*/
public class Test {

	public static void main(String[] args) {
		
		Student2 s1 = new Student2();
		Student2 s2 = new Student2();
		Student2 s3 = new Student2();
		s1.setS2(2);
		s2.setS2(3);
		s3.setS2(4);
		s1 = s2;
		
		System.out.println(s2.getS2());
		Integer q1 = 1;
		Integer q2 = 5;
		q1 = q2;
		q1 += 4;
		System.out.println(q2);
		String str1 = new String("abc");
		String str2 = new String("dbef");
		str1 = str2;
		System.out.println(str2);
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		sb1.append("111");
		StringBuffer sb3 = sb2.append("222");
		System.out.println(sb3.hashCode()+"...");
		System.out.println(sb2.hashCode()+"...");
		change(sb1,sb2);
		System.out.println(sb1.hashCode());
		System.out.println(sb1+"\t"+sb2);
	}
	
	public static void change(StringBuffer s1, StringBuffer s2) {
		System.out.println(s1.hashCode());
		System.out.println(s1);
		s1 = s2;
		System.out.println(s1.hashCode());
		System.out.println(s1);
		s2 = s2.append(s1);
		System.out.println(s1+"\t"+s2);
	}
	
}
