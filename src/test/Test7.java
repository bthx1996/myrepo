package test;

import java.util.Random;
import java.util.Scanner;

/**    
*  
* @author liuweixin  
* @date 2019年4月15日 下午3:20:34  
*/
public class Test7 {
	static String[] arr = {"石头","剪刀","布"};
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int user = 0;
		String choice = null;
		String player1 = null;
		String player2 = null;
		int result = -2;
		while(true) {
			System.out.println("请出拳：1.石头\t2.剪刀\t3.布");
			String userString = sca.next();
			if(!userString.equals("1") && !userString.equals("2") && !userString.equals("3")) {
				System.out.println("输入有误！");
				continue;
			}
			user = Integer.valueOf(userString);
			player1 = arr[user-1];
			System.out.println("你出了："+player1);
			player2 = arr[randomInt(0,3)];
			System.out.println("电脑出了："+player2);
			result = compare(player1, player2);
			System.out.print("结果：");
			if(result == 1) {
				System.out.println("你赢了！o(*￣▽￣*)ブ");
			}else if(result == 0) {
				System.out.println("平局~");
			}else if(result == -1) {
				System.out.println("你输了！`(*>﹏<*)′");
			}else {
				System.out.println("糟糕，出错了！");
			}
			System.out.println("继续吗？y:是\tn:否\t");
			choice = sca.next();
			if("y".equals(choice)) {
				continue;
			}else if("n".equals(choice)) {
				break;
			}else {
				System.out.println("输入有误！");
			}
		}
		
	}
	
	public static int randomInt(int min, int max) {
		return new Random().nextInt(max - min)+min;
	}
	
	public static int compare(String player1, String player2) {
		if("石头".equals(player1)) {
			if("石头".equals(player2))return 0;
			if("剪刀".equals(player2))return 1;
			if("布".equals(player2))return -1;
		}else if("剪刀".equals(player1)) {
			if("石头".equals(player2))return -1;
			if("剪刀".equals(player2))return 0;
			if("布".equals(player2))return 1;
		}else if("布".equals(player1)) {
			if("石头".equals(player2))return 1;
			if("剪刀".equals(player2))return -1;
			if("布".equals(player2))return 0;
		}
		return -2;
	}
}
