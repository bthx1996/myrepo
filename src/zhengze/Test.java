package zhengze;
/**    
*  
* @author liuweixin  
* @date 2019年7月14日 下午2:26:31  
*/
public class Test {

	public static void main(String[] args) {
		String str = "HP170658,\"HOW POW SHENG, LUKE\",K0210395A,上海,上海,新车,贷款,298130.00,20190329,24,7.5000,274952.95,0,0.00,正常,固定,A,70.00,20190630";
		String[] strArr = split(str);
		for(String s : strArr) {
			System.out.println(s);
		}
	}
	
	public static String[] split(String str) {
		return str.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
	}
}
