package test;

import java.util.Random;
import java.util.Scanner;

/**    
*  
* @author liuweixin  
* @date 2019��4��15�� ����3:20:34  
*/
public class Test7 {
	static String[] arr = {"ʯͷ","����","��"};
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int user = 0;
		String choice = null;
		String player1 = null;
		String player2 = null;
		int result = -2;
		while(true) {
			System.out.println("���ȭ��1.ʯͷ\t2.����\t3.��");
			String userString = sca.next();
			if(!userString.equals("1") && !userString.equals("2") && !userString.equals("3")) {
				System.out.println("��������");
				continue;
			}
			user = Integer.valueOf(userString);
			player1 = arr[user-1];
			System.out.println("����ˣ�"+player1);
			player2 = arr[randomInt(0,3)];
			System.out.println("���Գ��ˣ�"+player2);
			result = compare(player1, player2);
			System.out.print("�����");
			if(result == 1) {
				System.out.println("��Ӯ�ˣ�o(*������*)��");
			}else if(result == 0) {
				System.out.println("ƽ��~");
			}else if(result == -1) {
				System.out.println("�����ˣ�`(*>�n<*)��");
			}else {
				System.out.println("��⣬�����ˣ�");
			}
			System.out.println("������y:��\tn:��\t");
			choice = sca.next();
			if("y".equals(choice)) {
				continue;
			}else if("n".equals(choice)) {
				break;
			}else {
				System.out.println("��������");
			}
		}
		
	}
	
	public static int randomInt(int min, int max) {
		return new Random().nextInt(max - min)+min;
	}
	
	public static int compare(String player1, String player2) {
		if("ʯͷ".equals(player1)) {
			if("ʯͷ".equals(player2))return 0;
			if("����".equals(player2))return 1;
			if("��".equals(player2))return -1;
		}else if("����".equals(player1)) {
			if("ʯͷ".equals(player2))return -1;
			if("����".equals(player2))return 0;
			if("��".equals(player2))return 1;
		}else if("��".equals(player1)) {
			if("ʯͷ".equals(player2))return 1;
			if("����".equals(player2))return -1;
			if("��".equals(player2))return 0;
		}
		return -2;
	}
}
