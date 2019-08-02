package test;

import java.util.Scanner;

/**    
*  
* @author liuweixin  
* @date 2019年1月26日 上午10:48:12  
*/
public class Test3 {
	public static void main(String[] args) {
		/*
		String strall = "";
		Scanner sca = new Scanner(System.in);
			System.out.println("输入：");
			while(true) {
			String str = sca.next();
			strall = strall + str + ",";
				System.out.println("输出：");
				System.out.println(strall);
			}
			*/
		String str = "ECCAGOFTRDINF_T\r\n" + 
				"EENACCTINFIDCAGSINF_T\r\n" + 
				"EENCTRCTINFIDCAGSINF_T\r\n" + 
				"ECCCINF_T\r\n" + 
				"EDELETEREQUEST_T\r\n" + 
				"ECCCINFSGMT_T\r\n" + 
				"EINCOMESTATEMENTPROFIT_T\r\n" + 
				"ECCTRCTCERTREL_T\r\n" + 
				"ECCCCINF_T\r\n" + 
				"EBALANCESHEET_T\r\n" + 
				"EENCTRCTINFMDFC_T\r\n" + 
				"ECTRCTCERTREL_T\r\n" + 
				"ECRLTREPYMTINF_T\r\n" + 
				"EC_ECCCINFSGMT_T\r\n" + 
				"EIDREC_T\r\n" + 
				"EIMPINF_T\r\n" + 
				"EC_EENSECACCTINF_T\r\n" + 
				"EENCTRCTINF_T\r\n" + 
				"ERLTREPYMTINFSGMT_T\r\n" + 
				"EENCTFITGINF_T\r\n" + 
				"ECAGOFTRDINF_T\r\n" + 
				"EMMBINF_T\r\n" + 
				"EMOTGACLTALCTRCTINF_T\r\n" + 
				"ECASHFLOWS_T\r\n" + 
				"ERLTREPYMTINF_T\r\n" + 
				"EACTUCOTRLINF_T\r\n" + 
				"EQYCWALLDELETE_T\r\n" + 
				"EENACCTINF_T\r\n" + 
				"EINSTITUTIONBALANCESHEET_T\r\n" + 
				"EC_ERLTREPYMTINFSGMT_T\r\n" + 
				"EPLEINF_T\r\n" + 
				"ESHARHODINF_T\r\n" + 
				"EINCOMEANDEXPENSESTATEMENT_T\r\n" + 
				"EOTRREC_T\r\n" + 
				"EMARKCHANGE_T\r\n" + 
				"EENACCTINFMDFC_T\r\n" + 
				"EENBASINF_T\r\n" + 
				"EENICDNRLTPINF_T\r\n" + 
				"EENSECACCTINF_T\r\n" + 
				"EENESINFDLT_T";
		//stringHandle(str);
		//alter2(str);
		alter(str);
			
	}
	
	public static void stringHandle(String str) {
		String strNew = str.replace("\r\n", ",");
		System.out.println(strNew);
	}
	
	public static void alter(String str) {
		String[] strArr = str.split("\r\n");
		for(String s : strArr) {
			System.out.println("alter table "+s+" add infosource NVARCHAR2(20);");
		}
		
	}
	
	public static void alter2(String str) {
		String[] strArr = str.split("\r\n");
		for(String s : strArr) {
			System.out.println("alter table "+s+" add checkout nvarchar(10);");
		}
		
	}
}
