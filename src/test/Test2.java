package test;
/**    
*  
* @author liuweixin  
* @date 2019��1��22�� ����5:31:14  
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
			//�������������-1�����ַ����г�����
			//���ڴ����ַ����м����"���ַ�
			if(seed.indexOf("\"")>-1){
				seed=seed.replaceAll("\"","\"\"");
				seed='"'+seed+'"';
				vlogo=true;
			}
			
			//���ڴ����ַ����м����,�ŵ��ַ�
			if(seed.indexOf(",")>-1){
				//����Ѿ�������"��������,�ŵ�ʱ���ֻ���������һ��""
				if(!vlogo){
					seed='"'+seed+'"';
				}
			}
		}
		return seed+",";
	}
}
