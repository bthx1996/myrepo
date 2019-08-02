package test;
/**    
*  
* @author liuweixin  
* @date 2019年8月1日 上午10:43:36  
*/
public class Test31 {

	public static void main(String[] args) {
		String sql = "update table1 set name = ?,age = ?,sex = ? where id = ?";
		String[] strArr = getColumn(sql);
		for(String s : strArr) {
			System.out.println(s);
		}
	}
	
	public static String[] getColumn(String sql) {
		String strsub = sql.substring(sql.indexOf("set")+3,sql.indexOf("where")).trim();
		String[] strSplit = strsub.split(",");
		String[] resArr = new String[strSplit.length];
		for(int i = 0; i < strSplit.length; i++) {
			resArr[i] = strSplit[i].substring(0,strSplit[i].indexOf("=")).trim();
		}
		return resArr;
	}
}
