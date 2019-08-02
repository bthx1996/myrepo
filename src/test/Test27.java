package test;

import java.util.Arrays;
import java.util.List;

/**    
*  
* @author liuweixin  
* @date 2019年7月25日 上午8:59:51  
*/
public class Test27 {

	public static void main(String[] args) {
		String[] arr = {"正常","关注","次级","可疑","损失","PASS","SPECIAL MENTION","SUB STANDARD","DOUTFUL","LOSS"};
		List<String> list = Arrays.asList(arr);
		if(!list.contains("loss")) {
			System.out.println("bu");
			
		}else {
			System.out.println("是");
		}
	}
}
