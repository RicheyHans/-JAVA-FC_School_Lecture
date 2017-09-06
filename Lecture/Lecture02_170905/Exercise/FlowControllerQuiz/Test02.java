/*
 * 	    	A
 * 		   AA
 * 	 	  AAA
 * 		 AAAA
 * 		AAAAA	
 */

public class Test02 {
	public void run(String mark, int lines) {
		for(int i = 0; i < lines; i++) {
			for(int j = lines-1; j > i ; j--) {
				System.out.print(" ");
			}
			for(int k = 0; k <= i; k++) {
				System.out.print(mark);
			}
			System.out.println("");
		}
		System.out.println("---------------");	
	}
}
