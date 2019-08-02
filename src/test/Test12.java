package test;
/**    
*  
* @author liuweixin  
* @date 2019年5月21日 上午11:38:03  
*/
public class Test12 {

	public static void main(String[] args) {
		String str = "222313131313123231234567123456712345671234567";
		String[] strArr = null;
		if(str.length()%7 == 0) {
			strArr = new String[str.length()/7];
		}else {
			strArr = new String[str.length()/7+1];
		}
		int j = 0;
		for(int i = str.length(); i > 0; i = i - 7) {
			if(i - 7 >= 0) {
				strArr[j++] = str.substring(i - 7, i);
			}else {
				strArr[j++] = str.substring(0,i);
			}
		}
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
	}
}
