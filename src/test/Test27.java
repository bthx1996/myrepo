package test;

import java.util.Arrays;
import java.util.List;

/**    
*  
* @author liuweixin  
* @date 2019��7��25�� ����8:59:51  
*/
public class Test27 {

	public static void main(String[] args) {
		String[] arr = {"����","��ע","�μ�","����","��ʧ","PASS","SPECIAL MENTION","SUB STANDARD","DOUTFUL","LOSS"};
		List<String> list = Arrays.asList(arr);
		if(!list.contains("loss")) {
			System.out.println("bu");
			
		}else {
			System.out.println("��");
		}
	}
}
