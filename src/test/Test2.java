package test;
/**    
*  
* @author liuweixin  
* @date 2019年1月22日 下午5:31:14  
*/
public class Test2 {

	public static void main(String[] args) {
		/*
		String str = "123\",456";
		String str2 = formatString(str);
		System.out.println(str2);
		*/
		String a = "123<br>";
		String b = a.replace("<br>", "\r\n");
		System.out.println(b);
	}
	
	public static String formatString(String seed){
		if(seed==null){
			return ",";
		}
		
		if(seed.equals("")){
			seed="";
		}else {
			boolean vlogo =false;
			//如果索引不等于-1代表字符串中出现了
			//用于处理字符串中间带有"的字符
			if(seed.indexOf("\"")>-1){
				seed=seed.replaceAll("\"","\"\"");
				seed='"'+seed+'"';
				vlogo=true;
			}
			
			//用于处理字符串中间带有,号的字符
			if(seed.indexOf(",")>-1){
				//如果已经出现了"继续出现,号的时候就只在外面添加一次""
				if(!vlogo){
					seed='"'+seed+'"';
				}
			}
		}
		return seed+",";
	}
}
