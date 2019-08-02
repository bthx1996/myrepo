package test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**    
*  
* @author liuweixin  
* @date 2019��4��15�� ����10:19:25  
*/
public class Test6 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int flag = 0;
		int flagChu = 0;
		int flagZhong = 0;
		int flagGao = 0;
		int flagYue = 0;
		int flagDa = 0;
		for(int i = 0; i < 1000; i++) {
			String result = chouKa();
			list.add(result);
			if(!"SSR".equals(result)) {
				flag++;
				if(flag == 100 && flagChu == 0) {
					flagChu++;
					System.out.println("�鿨������"+(i+1)+"\t��ɳ��ǣ�");
					//System.out.println("����");
				}else if(flag == 200 && flagZhong == 0) {
					flagZhong++;
					System.out.println("�鿨������"+(i+1)+"\t����зǣ�");
					//System.out.println("�з�");
				}else if(flag == 300 && flagGao == 0) {
					flagGao++;
					System.out.println("�鿨������"+(i+1)+"\t��ɸ߷ǣ�");
					//System.out.println("�߷�");
				}else if(flag == 400 && flagYue == 0) {
					flagYue++;
					System.out.println("�鿨������"+(i+1)+"\t����¼��ڣ�");
					//System.out.println("�¼���");
				}else if(flag == 500 && flagDa == 0) {
					flagDa++;
					System.out.println("�鿨������"+(i+1)+"\t��ɴ�����ʦ��");
					//System.out.println("������ʦ");
				}
			}else {
				flag = 0;
			}
		}
		
		int countR = 0;
		int countSR = 0;
		int countSSR = 0;
		for(String flag1 : list) {
			if("R".equals(flag1)) {
				countR++;
			}else if("SR".equals(flag1)) {
				countSR++;
			}else if("SSR".equals(flag1)) {
				countSSR++;
			}else {
				System.out.println("�����ˣ���");
			}
		}
		System.out.println("R������Ϊ:"+new DecimalFormat("0.00%").format((float)countR/list.size()));
		System.out.println("SR������Ϊ:"+new DecimalFormat("0.00%").format((float)countSR/list.size()));
		System.out.println("SSR������Ϊ:"+new DecimalFormat("0.00%").format((float)countSSR/list.size()));
		System.out.println("SSR����������"+countSSR);
		System.out.println("�ܳ鿨����"+list.size());
		System.out.println("���Ǵ�����"+flagChu);
		System.out.println("�зǴ�����"+flagZhong);
		System.out.println("�߷Ǵ�����"+flagGao);
		System.out.println("�¼��ڴ�����"+flagYue);
		System.out.println("������ʦ������"+flagDa);
		/*
		List<Boolean> list = new ArrayList<Boolean>();
		for(int i = 0; i < 100000; i++) {
			boolean flag = getRandom2(0.878);
			list.add(flag);
		}
		
		int count = 0;
		for(boolean flag1 : list) {
			if(flag1 == true) {
				count++;
			}
		}
		System.out.println("��������Ϊ:"+new DecimalFormat("0.00%").format((float)count/list.size()));
		*/
		/*
		List<Boolean> list = new ArrayList<Boolean>();
		for(int i = 0; i < 100000; i++) {
			boolean flag = getRandom(1);
			list.add(flag);
		}
		
		int count = 0;
		for(boolean flag1 : list) {
			if(flag1 == true) {
				count++;
			}
		}
		System.out.println("��������Ϊ:"+new DecimalFormat("0.00%").format((float)count/list.size()));
		*/
	}
	
	public static int randomInt(int min, int max) {
		return (int) (Math.random()*(max - min) + min);
	}
	
	public static boolean getRandom(int flag) {
		int random = randomInt(1,11);
		if(random <= flag) {
			return true;
		}else {
			return false;
		}
	}
	
	public static double randomDouble(int min, int max) {
		return Math.random()*(max - min) + min;
	}
	
	public static boolean getRandom2(double flag) {
		double random = randomDouble(0,1);
		if(random <= flag) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String chouKa() {
		//78.8% 20% 1.2%
		/*
		int random = randomInt(1, 1001);
		if(random >= 213) {
			return "R";
		}else if(random >= 13) {
			return "SR";
		}else if(random >= 1){
			return "SSR";
		}else {
			return "...";
		}
		*/
		//79% 20% 1%
		int random = randomInt(1, 101);
		if(random >= 22) {
			return "R";
		}else if(random >= 2) {
			return "SR";
		}else if(random >= 1){
			return "SSR";
		}else {
			return "...";
		}
	}
}
