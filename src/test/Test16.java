package test;

import java.util.List;

/**    
*  
* @author liuweixin  
* @date 2019��6��13�� ����10:47:29  
*/
public class Test16 {

	public static void main(String[] args) {
		/*
		int d = 0;
		for(int i = 1; i < 5; i++) {
			for(int j = 1; j < 5; j++) {
				if(j == i) {
					continue;
				}
				for(int k = 1; k < 5; k++) {
					if(k == i || k == j) {
						continue;
					}
					d = i * 100 + j * 10 + k;
					System.out.println(d);
				}
			}
		}
		*/
		/*
		int i,j,x=0,sum=0,n=100;     //ִ��һ��
	    for(i=1;i<=n;i++){           //ִ��n+1��
	        for(j=1;j<=n;j++){       //ִ��n*(n+1)��
	            x++;                 //ִ��n*n��
	            sum=sum+x;
	        }
	    }
	    System.out.println(sum);
	    */
		/*
		int i = Integer.MAX_VALUE;
		int j = i+1;
		long k = (long)j-1;
		System.out.println(j-1);
		System.out.println(k);
		System.out.println(i+" "+j);
		*/
		
	//	System.out.println("yu="+" "+"hu="+""+"ji="+"");
		/*
		StringBuffer sb = new StringBuffer("123");
		Outer s = new Outer();
		System.out.println(s);
		*/
		/*
		System.out.println(test());
		*/
		System.out.println(15.4%10);
	}
	
	public static boolean test() {
		try {
			List<Object> array = null;
			System.out.println(array.size());
			return true;
		}catch(Exception e) {
			System.out.println("error");
			System.out.println("123");
			return false;
		}finally {
			System.out.println("finally");
			return true;
		}
	}
}
