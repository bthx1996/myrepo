package test;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**    
*  
* @author liuweixin  
* @date 2019年5月16日 下午6:05:20  
*/
public class Test11 {

	public static void main(String[] args) {
		/*
		int x = 1,y = 6;
		while(--y>0) {
			x--;
		}
		System.out.println(x);
		System.out.println(y);
		*/
		/*
		System.out.println(Runtime.getRuntime().availableProcessors());
		*/
		/*
		boolean x = true;
		boolean y = false;
		short z = 42;
		if((z++ == 42) && (y == true))
			z++;
		if((x == false) || (++z == 45))
			z++;
		System.out.println(z);
		*/
		/*
		boolean flag = false;
		while(flag) {
			System.out.println(1);
		}
		System.out.println(2);
		*/
		/*
		for(int i = 0; i <= 10/1; i++){
			for(int j = 0 ; j <= 10/2; j++) {
				for(int k = 0; k <= 10/5; k++) {
					if(1*i + 2*j + 5*k == 10) {
						System.out.println(i+"\t"+j+"\t"+k);
					}
				}
			}
		}
		*/
		/*
		int n = 2;
		int s = 0;
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = ++s;
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		*/
		//System.out.println((false&&false));
		int a = 5; a = a++; System.out.println(a);
	}
}


