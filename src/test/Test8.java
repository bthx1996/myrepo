package test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
/**    
*  
* @author liuweixin  
* @date 2019��4��15�� ����4:00:54  
*/
public class Test8 {
	//����-9 ˳��-8 ��-7 ˳��-6 ����-5 ����-0
	static String[] type = {"����","����","����","÷��"};
	static String[] value = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	static List<String> cardList = new ArrayList<String>();
	static Map<String, Integer> map = new HashMap<String, Integer>();
	static int countTotal = 0;//�ܾ���
	static int count1 = 0;//���1Ӯ�ľ���
	static int count2 = 0;//���2Ӯ�ľ���
	static int count3 = 0;//ƽ����
	static int round = 0;
	static String player1 = null;
	static String player2 = null;
	public static void main(String[] args) throws InterruptedException {
		createCard();
		System.out.println("����������ǳƣ�");
		Scanner sca = new Scanner(System.in);
		player1 = sca.next();
		player2 = "����";
		System.out.println("��Ϸ��ʼ��");
		while(true) {
			System.out.println("ROUND "+(++round));
			zhaJinHua();
			System.out.println("������y:��\tn:��");
			String choice = sca.next();
			if(choice.equals("y")) {
				continue;
			}else {
				break;
			}			
		}					
		System.out.println("^^^^^^^^^^^^^^");
		System.out.println("�ܾ�����" + countTotal);
		System.out.println(player1+"Ӯ�ľ�����" + count1);
		System.out.println(player1+"��ʤ�ʣ�" + new DecimalFormat("0.00%").format((float)count1/countTotal));
		System.out.println(player2+"Ӯ�ľ�����" + count2);
		System.out.println(player2+"��ʤ�ʣ�" + new DecimalFormat("0.00%").format((float)count2/countTotal));
		System.out.println("ƽ������" + count3);
		System.out.println("ƽ�ָ���Ϊ��" + new DecimalFormat("0.00%").format((float)count3/countTotal));
		System.out.print("�����Ƴ��ִ�����");
		int total = 0;
		for(int a : map.values()) {
			total += a;
		}
		System.out.println(total);
		String cardMax = null;
		String cardMin = null;
		String card1 = null;
		double dMax = 0;
		double dMin = 1;
		double d = 0;
		List<Double> list = new ArrayList<Double>();
		for(Entry<String, Integer> s : map.entrySet()) {
			card1 = s.getKey();
			d = (float)map.get(card1)/total;
			System.out.print(card1+":"+map.get(card1)+"  ����Ϊ��"+new DecimalFormat("0.0000%").format(d)+"\t");
			if(d >= dMax) {
				dMax = d;
				cardMax = card1;
			}
			if(d <= dMin) {
				dMin = d;
				cardMin = card1;
			}
			list.add(d);
		}
		System.out.println();
		double dTotal = 0;
		for(int i = 0; i < list.size(); i++) {
			dTotal += list.get(i);
		}
		System.out.println("ƽ������Ϊ��"+new DecimalFormat("0.00000000000%").format((float)dTotal/list.size()));
		System.out.println("������ߵ��ƣ�"+cardMax+"  ����Ϊ��"+map.get(cardMax)+"  ����Ϊ��"+new DecimalFormat("0.0000%").format(dMax));
		System.out.println("������͵��ƣ�"+cardMin+"  ����Ϊ��"+map.get(cardMin)+"  ����Ϊ��"+new DecimalFormat("0.0000%").format(dMin));
	}
	
	public static void createCard() {
		for(int i = 0; i < type.length; i++) {
			for(int j = 0; j <value.length; j++) {
				cardList.add(type[i]+value[j]);
			}
		}
	}
	
	public static void zhaJinHua() throws InterruptedException {
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		Scanner sca = new Scanner(System.in);
		int index = 0;
		String card = null;
		if(cardList.size() <= 4) {
			System.out.println("û���ˣ�");
			System.out.println("����ϴ����...");
			cardList.clear();
			createCard();
			//return;
		}
		for(int i = 0; i < 3; i++) {
			index = randomInt(0,cardList.size());
			card = cardList.get(index);
			if(set1.contains(card)) {
				i--;
				continue;
			}else {
				set1.add(card);				
				cardList.remove(index);
				if(!map.containsKey(card)) {
					map.put(card, 1);
				}else {
					map.put(card, map.get(card)+1);
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			index = randomInt(0,cardList.size());
			card = cardList.get(index);
			if(set2.contains(card)) {
				i--;
				continue;
			}else {
				set2.add(card);
				cardList.remove(index);
				if(!map.containsKey(card)) {
					map.put(card, 1);
				}else {
					map.put(card, map.get(card)+1);
				}
			}
		}
		
		int check1 = -1;
		System.out.print(player1+"��\t");
		for(String s : set1) {
			System.out.print(s+"  ");
		}
		System.out.println();
		check1 = check(set1);
		if(check1 != -1) {
			System.out.println(transform(check1));
		}
		
		int check2 = -1;
		System.out.print(player2+"��\t");
		for(String s : set2) {
			System.out.print(s+"  ");
		}
		System.out.println();
		check2 = check(set2);
		if(check2 != -1) {
			System.out.println(transform(check2));
		}
		
		
		int result = -2;
		if(check1 != check2) {
			result = check1>check2?1:-1;
		}else {
			result = compare(check1, set1, set2);
		}
		countTotal++;
		if(result == 1) {
			count1++;
			System.out.println(player1+"ʤ����");
		}else if(result == -1){
			count2++;
			System.out.println(player2+"ʤ����");
		}else if(result == 0){
			System.out.println("ƽ�֣�");
			count3++;
			//Thread.sleep(5000);
//			System.out.println("������y:��\tn:��");
//			String c = sca.next();
//			if("y".equals(c)) {
//				
//			}else {
//				return;
//			}
			
		}else {
			System.out.println("ս����������");
		}
		System.out.println("*************************");
	}
	
	public static int randomInt(int min, int max) {
		return new Random().nextInt(max - min) + min;
	}
	
	public static int check(Set<String> set) {
		String[] arr = new String[3];
		int i = 0;
		for(String s : set) {
			arr[i++] = s;
		}
		if(arr[0].substring(2).equals(arr[1].substring(2)) || arr[0].substring(2).equals(arr[2].substring(2)) || arr[1].substring(2).equals(arr[2].substring(2))) {
			if(arr[0].substring(2).equals(arr[1].substring(2)) && arr[0].substring(2).equals(arr[2].substring(2))) {
				return 9;
			}else {
				return 5;
			}
		}
		if(arr[0].substring(0, 2).equals(arr[1].substring(0, 2)) && arr[0].substring(0, 2).equals(arr[2].substring(0, 2))) {			
			if(checkOrder(arr)) {
				return 8;
			}
			return 7;
		}
		if(checkOrder(arr)) {
			return 6;
		}
		return 0;
	}
	
	public static boolean checkOrder(String[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < value.length; j++) {
				if(arr[i].substring(2).equals(value[j])) {
					list.add(j);
				}
			}			
		}
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1 - o2;
			}
		});
		
		if(list.get(0) == 0 && list.get(1) == 11 && list.get(2) == 12) return true;
		
		if((list.get(1) - list.get(0) == 1) && (list.get(2) - list.get(1) == 1)) return true;
		
		return false;
	}
	
	public static String transform(int num) {
		switch(num) {
		case 9:return "����";
		case 8:return "˳��";
		case 7:return "��";
		case 6:return "˳��";
		case 5:return "����";
		case 0:return "����";
		default:return "������";
		}
	}
	
	public static int compare(int check, Set<String> set1, Set<String> set2) {
		//String[] arr1 = new String[3];
		//String[] arr2 = new String[3];
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		//int flag = 0;
		/*
		for(String s : set1) {
			arr1[flag++] = s;
		}
		flag = 0;
		for(String s : set2) {
			arr2[flag++] = s;
		}
		*/
		for(String s : set1) {
			for(int i = 0 ; i < value.length; i++) {
				if(s.substring(2).equals(value[i])) {
					list1.add(i);
				}
			}
		}
		
		for(String s : set2) {
			for(int i = 0 ; i < value.length; i++) {
				if(s.substring(2).equals(value[i])) {
					list2.add(i);
				}
			}
		}
		
		list1.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		list2.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		switch(check) {
		case 9:if(list1.get(0) == 0) return 1;
		       if(list2.get(0) == 0) return -1;
			   if(list1.get(0) > list2.get(0)) {
				   return 1;
			   }else if(list1.get(0) < list2.get(0)){
				   return -1;
			   }else {
				   return 0;
			   }
		case 6:	   
		case 8:if(list1.get(0) != 0 && list2.get(0) != 0) {
					if(list1.get(2) > list2.get(2)) {
						return 1;
					}else if(list1.get(2) < list2.get(2)) {
						return -1;
					}else {
						return 0;
					}
				}
				
				if(list1.get(0) == 0 && list2.get(0) == 0) {
					if(list1.get(2) > list2.get(2)) {
						return 1;
					}else if(list1.get(2) < list2.get(2)) {
						return -1;
					}else {
						return 0;
					}
				}
				
				if(list1.get(0) == 0) {
					if(list1.get(2) >= list2.get(2)) {
						return 1;
					}else if(list1.get(2) < list2.get(2)) {
						return -1;
					}
				}
				
				if(list2.get(0) == 0) {
					if(list1.get(2) > list2.get(2)) {
						return 1;
					}else if(list1.get(2) <= list2.get(2)) {
						return -1;
					}
				}
		case 7:
		case 0:if(list1.get(0).equals(0)) {
					if(list2.get(0).equals(0)) {
						if(list1.get(2) > list2.get(2)) {
							return 1;
						}else if(list1.get(2) < list2.get(2)){
							return -1;
						}else {
							if(list1.get(1) > list2.get(1)) {
								return 1;
							}else if(list1.get(1) < list2.get(1)){
								return -1;
							}else {
								return 0;
							}
						}
					}else {
						return 1;
					}					
				}
		
				if(list2.get(0).equals(0)) return -1;
				
				if(list1.get(2) > list2.get(2)) {
					return 1;
				}else if(list1.get(2) < list2.get(2)){
					return -1;
				}else {
					if(list1.get(1) > list2.get(1)) {
						return 1;
					}else if(list1.get(1) < list2.get(1)){
						return -1;
					}else {
						if(list1.get(0) > list2.get(0)) {
							return 1;
						}else if(list1.get(0) < list2.get(0)){
							return -1;
						}else {
							return 0;
						}
					}
				}
		case 5: if(list1.get(1) == 0) {
					if(list2.get(1) == 0) {
						if(list1.get(2) > list2.get(2)) {
							return 1;
						}else if(list1.get(2) < list2.get(2)) {
							return -1;
						}else {
							return 0;
						}
					}else {
						return 1;
					}
				}
				if(list1.get(1) > list2.get(1)) {
					return 1;
				}else if(list1.get(1) < list2.get(1)) {
					return -1;
				}else {
					int flag1 = 0;
					if(list1.get(flag1) == list1.get(1)) {
						flag1 = 2;
					}
					int flag2 = 0;
					if(list2.get(flag2) == list2.get(1)) {
						flag2 = 2;
					}
					if(list1.get(flag1) > list2.get(flag2)) {
						return 1;
					}else if(list1.get(flag1) < list2.get(flag2)){
						return -1;
					}else {
						return 0;
					}
				}
		default:return -2;
		}
	}
}
