package test;
/**    
*  
* @author liuweixin  
* @date 2019年6月6日 上午11:23:55  
*/
public class Test15 {

	public static void main(String[] args) {
		String str = "EBALANCESHEET_T\r\n" + 
				"ECCCINFSGMT_T\r\n" + 
				"EMOTGACLTALCTRCTINF_T\r\n" + 
				"EOTRREC_T\r\n" + 
				"EPLEINF_T\r\n" + 
				"EIMPINF_T\r\n" + 
				"ECASHFLOWS_T\r\n" + 
				"EINCOMEANDEXPENSESTATEMENT_T\r\n" + 
				"EINCOMESTATEMENTPROFIT_T\r\n" + 
				"EINSTITUTIONBALANCESHEET_T\r\n" + 
				"EMARKCHANGE_T\r\n" + 
				"EENSECACCTINF_T\r\n" + 
				"ERLTREPYMTINFSGMT_T\r\n" + 
				"EQYCWALLDELETE_T\r\n" + 
				"EDELETEREQUEST_T\r\n" + 
				"EACTUCOTRLINF_T\r\n" + 
				"EC_ECCCINFSGMT_T\r\n" + 
				"EC_EENSECACCTINF_T\r\n" + 
				"EC_ERLTREPYMTINFSGMT_T\r\n" + 
				"ECAGOFTRDINF_T\r\n" + 
				"ECCAGOFTRDINF_T\r\n" + 
				"ECCCCINF_T\r\n" + 
				"ECCCINF_T\r\n" + 
				"ECCTRCTCERTREL_T\r\n" + 
				"ECRLTREPYMTINF_T\r\n" + 
				"ECTRCTCERTREL_T\r\n" + 
				"EENACCTINF_T\r\n" + 
				"EENACCTINFMDFC_T\r\n" + 
				"EENBASINF_T\r\n" + 
				"EENCTFITGINF_T\r\n" + 
				"EENCTRCTINF_T\r\n" + 
				"EENCTRCTINFMDFC_T\r\n" + 
				"EENESINFDLT_T\r\n" + 
				"EENICDNRLTPINF_T\r\n" + 
				"EIDREC_T\r\n" + 
				"EMMBINF_T\r\n" + 
				"ESHARHODINF_T\r\n" + 
				"ERLTREPYMTINF_T";
		String[] strArr = str.split("\r\n");
		int j = 0;
		for(int i = 0; i < strArr.length; i++) {
			System.out.println("alter table "+strArr[i]+" add (infosource NVARCHAR2(20));");
			j++;
		}
		System.out.println(j);
	}
}
