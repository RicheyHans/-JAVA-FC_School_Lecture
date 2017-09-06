/*
 * 	    x
 * 	   xxx
 * 	  xxxxx  
 * 	 xxxxxxx
 * 	xxxxxxxxx	
 */

public class Test03 {
	public void run(String mark, int lines) {
		for(int i = 0; i < lines; i++) {
			for(int j = lines; j > i; j--) {
				System.out.print(" ");
			}
			for(int k = 0; k <=(i*2); k++) {
				System.out.print(mark);
			}
			System.out.println(" ");
		}
		System.out.println("---------------");	
	}

}
